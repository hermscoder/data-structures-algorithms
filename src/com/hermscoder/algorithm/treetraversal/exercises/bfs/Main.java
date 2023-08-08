package com.hermscoder.algorithm.treetraversal.exercises.bfs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("Breadth First Search:");
        System.out.println(myBST.BFS());

        /*
            EXPECTED OUTPUT:
            ----------------
            Breadth First Search:
            [47, 21, 76, 18, 27, 52, 82]

        */

    }
}

class BinarySearchTree {
    public Node root;

    public ArrayList<Integer> BFS() {
        var results = new ArrayList<Integer>();
        var queue = new LinkedList<Node>();

        queue.add(root);

        while (queue.size() > 0) {
            Node dequeuedElement = queue.remove();
            results.add(dequeuedElement.value);

            if(dequeuedElement.left != null) {
                queue.add(dequeuedElement.left);
            }
            if(dequeuedElement.right != null) {
                queue.add(dequeuedElement.right);
            }
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
}