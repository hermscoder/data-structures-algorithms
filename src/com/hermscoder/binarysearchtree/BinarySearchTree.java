package com.hermscoder.binarysearchtree;

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

    public void printTree() {
        PrintUtils.printTree(this);
    }

    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

    }
}
