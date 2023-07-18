package com.hermscoder.datastructure.recursivebinarysearchtree;


public class RecursiveBinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        root = rInsert(root, value);
        return true;
    }

    private Node rInsert(Node currentNode, int value) {
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
        if (currentNode == null) return false;

        if (currentNode.value == searchedValue) return true;

        if (searchedValue < currentNode.value) {
            return rContains(currentNode.left, searchedValue);
        } else {
            return rContains(currentNode.right, searchedValue);
        }
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if(currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null) {
                return null;
            } else if(currentNode.left == null) {
                    currentNode = currentNode.right;
            } else if(currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    private int minValue(Node currentNode) {
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
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
