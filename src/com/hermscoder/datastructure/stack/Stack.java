package com.hermscoder.datastructure.stack;


public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height != 0) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public Node pop() {
        if(height == 0) return null;

        Node poppedItem = top;
        top = top.next;
        poppedItem.next = null;

        height--;
        return poppedItem;
    }
}
