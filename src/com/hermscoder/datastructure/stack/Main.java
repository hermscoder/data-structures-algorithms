package com.hermscoder.datastructure.stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(7);

        System.out.println("Top: " + myStack.getTop().value);
        System.out.println("Height: " + myStack.getHeight());
        myStack.printStack();

        myStack.push(23);

        System.out.println("Top: " + myStack.getTop().value);
        System.out.println("Height: " + myStack.getHeight());
        myStack.printStack();

        myStack.push(3);
        myStack.push(11);

        System.out.println("Top: " + myStack.getTop().value);
        System.out.println("Height: " + myStack.getHeight());
        myStack.printStack();

        System.out.println("Pop: " + myStack.pop());

        System.out.println("Top: " + myStack.getTop().value);
        System.out.println("Height: " + myStack.getHeight());
        myStack.printStack();
    }
}
