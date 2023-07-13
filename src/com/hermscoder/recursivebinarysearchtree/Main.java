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

        rbst.printTree();
    }
}
