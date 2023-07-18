package com.hermscoder.datastructure.binarysearchtree;

import com.hermscoder.datastructure.binarysearchtree.BinarySearchTree.Node;

public class PrintUtils {

    public static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public static void printTree(int[][] M, Node root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.value;
        printTree(M, root.left, col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.right, col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }

    public static void printTree(BinarySearchTree tree) {
        int h = height(tree.getRoot());
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, tree.getRoot(), col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0)
                    System.out.print("  ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }
}
