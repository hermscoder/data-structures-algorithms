package com.hermscoder.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);
        bst.insert(27);
        bst.insert(81);

        bst.printTree();
        System.out.println("Contains 81: "+ bst.contains(81));
        System.out.println("Contains 52: "+ bst.contains(52));
    }
}
