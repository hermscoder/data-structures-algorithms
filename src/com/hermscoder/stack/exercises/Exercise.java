package com.hermscoder.stack.exercises;

public class Exercise {
    public static void main(String[] args) {
        Stack myStack = new Stack(2);
        myStack.push(1);

        // (2) Items - Returns 1 Node
        System.out.println(myStack.pop().value);
        // (1) Item - Returns 2 Node
        System.out.println(myStack.pop().value);
        // (0) Items - Returns null
        System.out.println(myStack.pop());
    }
}

class Stack {

    private Node top;
    private int height;

    public Stack(int value) {
        top = new Node(value);
        height++;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void push(int value) {
        Node temp = new Node(value);

        if (height != 0) {
            temp.next = top;
        }
        top = temp;

        height++;

    }

    public Node pop() {
        if(height == 0) return null;

        Node temp = top;

        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

}


