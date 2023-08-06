package com.hermscoder.algorithm.treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
}
