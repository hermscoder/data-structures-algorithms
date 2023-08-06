package com.hermscoder.algorithm.treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    private Node root;

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

    public boolean contains(int searchedValue) {
        if (root == null) return false;

        Node temp = root;
        while (temp != null) {
            if (searchedValue == temp.value) return true;
            if (searchedValue < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

    }

    public ArrayList<Integer> BFS() {

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(root);

        Node dequeuedNode;
        while (queue.size() > 0) {
            dequeuedNode = queue.remove();
            results.add(dequeuedNode.value);
            if (dequeuedNode.left != null) {
                queue.add(dequeuedNode.left);
            }
            if (dequeuedNode.right != null) {
                queue.add(dequeuedNode.right);
            }
        }

        return results;
    }

    public ArrayList<Integer> dfsInOrderRecursive() {
        return rDfsInOrder(new ArrayList<>(), root);
    }

    private ArrayList<Integer> rDfsInOrder(ArrayList<Integer> results, Node currentNode) {
        if(currentNode.left != null) {
            rDfsInOrder(results, currentNode.left);
        }
        results.add(currentNode.value);
        if(currentNode.right != null) {
            rDfsInOrder(results, currentNode.right);
        }
        return results;
    }

    public ArrayList<Integer> dfsInOrderObjectInstantiation() {
        var results = new ArrayList<Integer>();

        class Traversal {
            Traversal(Node currentNode) {
                if(currentNode.left != null) {
                    new Traversal(currentNode.left);
                }
                results.add(currentNode.value);
                if(currentNode.right != null) {
                    new Traversal(currentNode.right);
                }
            }
        }
        new Traversal(root);
        return results;
    }
    public ArrayList<Integer> dfsPostOrderRecursive() {
        return rDfsPostOrder(new ArrayList<>(), root);
    }

    private ArrayList<Integer> rDfsPostOrder(ArrayList<Integer> results, Node currentNode) {
        if(currentNode.left != null) {
            rDfsPostOrder(results, currentNode.left);
        }
        if(currentNode.right != null) {
            rDfsPostOrder(results, currentNode.right);
        }

        results.add(currentNode.value);
        return results;
    }

    public ArrayList<Integer> dfsPostOrderObjectInstantiation() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traversal {
            Traversal(Node currentNode) {
                if(currentNode.left != null) {
                    new Traversal(currentNode.left);
                }
                if(currentNode.right != null) {
                    new Traversal(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Traversal(root);
        return results;
    }

    public ArrayList<Integer> dfsPreOrderObjectInstantiation() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> dfsPreOrderRecursive() {
        return rDFSPreOrder(new ArrayList<>(), root);
    }

    private ArrayList<Integer> rDFSPreOrder(ArrayList<Integer> array, Node currentNode) {
        array.add(currentNode.value);

        if (currentNode.left != null) {
            rDFSPreOrder(array, currentNode.left);
        }
        if (currentNode.right != null) {
            rDFSPreOrder(array, currentNode.right);
        }
        return array;
    }

    public List<Integer> dfsPreOrderNonRecursive(Node root) {
        //initialize array list
        List<Integer> preOrder = new ArrayList<>();

        //if tree is empty then we return empty list
        if (root == null) return preOrder;

        //initialize stack
        Stack<Node> st = new Stack<Node>();

        //push root element to stack
        st.push(root);

        //loop runs till stack in not empty
        while (!st.isEmpty()) {
            //pop the top element in stack
            root = st.pop();
            //add it to list
            preOrder.add(root.value);
            //check if left and right elements are present
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        return preOrder;
    }
}
