package com.hermscoder.recursivebinarysearchtree;


public class RecursiveBinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        root = rInsert(root, value);
        return true;
    }

    private Node rInsert(Node currentNode,int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public boolean contains(int searchedValue) {
        return rContains(root, searchedValue);
    }

    private boolean rContains(Node currentNode, int searchedValue) {
        if(currentNode == null) return false;

        if(currentNode.value == searchedValue) return true;

        if (searchedValue < currentNode.value) {
            return rContains(currentNode.left, searchedValue);
        } else {
            return rContains(currentNode.right, searchedValue);
        }
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
