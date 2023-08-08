package com.hermscoder.algorithm.treetraversal.exercises.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MainPreOrder {
    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("DFS PreOrder:");
        System.out.println( myBST.DFSPreOrder() );
        System.out.println("DFS PostOrder:");
        System.out.println( myBST.DFSPostOrder() );
        System.out.println("DFS InOrder:");
        System.out.println( myBST.DFSInOrder() );


        /*
            EXPECTED OUTPUT:
            ----------------
            DFS PreOrder:
            [47, 21, 18, 27, 76, 52, 82]
            DFS PostOrder:
            [18, 27, 21, 52, 82, 76, 47]
            DFS InOrder:
            [18, 21, 27, 47, 52, 76, 82]

        */

    }
}

class BinarySearchTree {

    public Node root;

    public ArrayList<Integer> DFSPreOrder() {
        return rDFSPreOrder(new ArrayList<>(), root);
    }

    private ArrayList<Integer> rDFSPreOrder(ArrayList<Integer> results, Node currentNode) {
        results.add(currentNode.value);

        if(currentNode.left != null) {
            rDFSPreOrder(results, currentNode.left);
        }

        if(currentNode.right != null) {
            rDFSPreOrder(results, currentNode.right);
        }
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        return rDFSPostOrder(new ArrayList<Integer>(), root);
    }

    private ArrayList<Integer> rDFSPostOrder(ArrayList<Integer> results, Node currentNode) {
        if(currentNode.left != null) {
            rDFSPostOrder(results, currentNode.left);
        }

        if(currentNode.right != null) {
            rDFSPostOrder(results, currentNode.right);
        }
        results.add(currentNode.value);
        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        return rDFSInOrder(new ArrayList<>(), root);
    }

    private ArrayList<Integer> rDFSInOrder(ArrayList<Integer> results, Node currentNode) {
        if (currentNode.left != null) {
            rDFSInOrder(results, currentNode.left);
        }
        results.add(currentNode.value);
        if (currentNode.right != null) {
            rDFSInOrder(results, currentNode.right);
        }
        return results;
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    // WRITE DFS_PREORDER METHOD HERE //
    //                                //
    //                                //
    //                                //
    //                                //
    ////////////////////////////////////

}