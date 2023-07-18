package com.hermscoder.datastructure.recursivebinarysearchtree.exercises;


public class Exercise {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        System.out.println( "Before: ");
        myBST.printTree();


        myBST.deleteNode(2);
        System.out.println( "After: ");
        myBST.printTree();


        /*
            EXPECTED OUTPUT:
            ----------------
			Root: 2
			Root->Left: 1
			Root->Right: 3

			Root: 3
			Root->Left: 1
			Root->Right: null

        */
    }

}

class BinarySearchTree {

    private Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

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

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) return false;

        if(currentNode.value == value) return true;

        if(value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) { return rContains(root, value); }

    public Node rInsert(Node currentNode, int value) {

        if (currentNode == null) return new Node(value);

        if(value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void rInsert(int value) {
        root = rInsert(root, value);
    }

    public int minValue(Node startNode) {
        if(startNode != null) {
            while(startNode.left != null) {
                startNode = startNode.left;
            }
        }

        return startNode.value;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if(currentNode == null) return null;

        if(value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null) {
                return null;
            } else if(currentNode.right == null) {
                currentNode = currentNode.left;
            } else if(currentNode.left == null) {
                currentNode = currentNode.right;
            } else {
                int minValue = minValue(currentNode.right);
                currentNode.value = minValue;
                currentNode.right = deleteNode(currentNode.right, minValue);
            }
        }
        return currentNode;
    }


    public void printTree() {
        BinarySearchTree.PrintUtils.printTree(this);
    }

    /**
     * Class taken from https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
     */
    static class PrintUtils {

        public static int height(BinarySearchTree.Node root) {
            if (root == null)
                return 0;
            return Math.max(height(root.left), height(root.right)) + 1;
        }


        public static int getcol(int h) {
            if (h == 1)
                return 1;
            return getcol(h - 1) + getcol(h - 1) + 1;
        }

        public static void printTree(int[][] M, BinarySearchTree.Node root, int col, int row, int height) {
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
}

