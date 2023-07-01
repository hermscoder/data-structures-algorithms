package com.hermscoder.stack.leetcode;

import java.util.ArrayList;

public class StackWithArrayList {

    public static void main(String[] args) {


        Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("Stack before pop():");
        myStack.printStack();

        System.out.println("\nPopped node:");
        System.out.println(myStack.pop());

        System.out.println("\nStack after pop():");
        myStack.printStack();

    }

}

