package com.hermscoder.binarysearchtree.exercises;

public class Exercises {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);


        System.out.println("BST Contains 27:");
        System.out.println(myBST.contains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.contains(17));

    }
}

class BinarySearchTree {

    private Node root;

    public boolean contains(int value) {
        if(root == null) return false;

        Node temp = root;
        while(temp != null) {
            if(value == temp.value) return true;

            if(value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
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

    public Node getRoot() {
        return root;
    }

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }
}