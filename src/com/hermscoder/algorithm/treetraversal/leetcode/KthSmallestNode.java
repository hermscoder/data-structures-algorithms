package com.hermscoder.algorithm.treetraversal.leetcode;

import java.util.ArrayList;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 *
 * Examples:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 */
public class KthSmallestNode {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.kthSmallest(1));  // Expected output: 2
        System.out.println(bst.kthSmallest(3));  // Expected output: 4
        System.out.println(bst.kthSmallest(6)); // Expected output: 7
    }
}

class BinarySearchTree {

    private Node root;

    ArrayList<Integer> result = new ArrayList<>();

    public int kthSmallest(int k) {
        result.clear();
        if(root==null) return 0;
        rKthSmallest(root, k);
        return result.get(k - 1);
    }

    private void rKthSmallest(Node currentNode, int k) {
        if (currentNode.left != null) {
            rKthSmallest(currentNode.left, k);
        }

        result.add(currentNode.value);

        if(result.size() == k) return;

        if (currentNode.right != null) {
            rKthSmallest(currentNode.right, k);
        }
    }

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
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

}