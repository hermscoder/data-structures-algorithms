package com.hermscoder.stack.leetcode;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

    }

    public static void sortStack(Stack<Integer> inputStack) {
        Stack<Integer> additionalStack = new Stack();

        additionalStack.push(inputStack.pop());

        while(!inputStack.isEmpty()) {
            Integer tmp = inputStack.pop();
            while (!additionalStack.isEmpty() && additionalStack.peek() > tmp) {
                inputStack.push(additionalStack.pop());
            }
            additionalStack.push(tmp);
        }

        while (!additionalStack.isEmpty()) {
            inputStack.push(additionalStack.pop());
        }
    }


}
