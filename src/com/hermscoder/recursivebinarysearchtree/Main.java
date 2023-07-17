package com.hermscoder.recursivebinarysearchtree;


public class Main {
    public static void main(String[] args) {
        RecursiveBinarySearchTree rbst = new RecursiveBinarySearchTree();

        rbst.insert(47);
        rbst.insert(21);
        rbst.insert(76);
        rbst.insert(18);
        rbst.insert(27);
        rbst.insert(52);
        rbst.insert(82);
        rbst.insert(25);
        rbst.insert(24);
        rbst.insert(26);
        rbst.insert(29);
        rbst.insert(30);
        rbst.insert(28);

        System.out.println("Before removing:");
        rbst.printTree();
        rbst.deleteNode(27);
        System.out.println("After removing:");
        rbst.printTree();
    }
}
