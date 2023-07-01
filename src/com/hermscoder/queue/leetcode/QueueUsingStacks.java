package com.hermscoder.queue.leetcode;

import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String[] args) {
// Create a new queue
        MyQueue q = new MyQueue();

        // Enqueue some values
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Output the front of the queue
        System.out.println("Front of the queue: " + q.peek());

        // Dequeue some values
        System.out.println("Dequeued value: " + q.dequeue());
        System.out.println("Dequeued value: " + q.dequeue());

        // Enqueue another value
        q.enqueue(4);

        // Output the front of the queue again
        System.out.println("Front of the queue: " + q.peek());

        // Dequeue all remaining values
        System.out.println("Dequeued value: " + q.dequeue());
        System.out.println("Dequeued value: " + q.dequeue());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + q.isEmpty());

        // Dequeue from an empty queue and check if it returns null
        System.out.println("Dequeued value from empty queue: " + q.dequeue());
    }
}

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        if(isEmpty()) return null;

        return stack1.pop();
    }

    /**
    ENQ: 1
    STACK1: 1
    STACK2:

    ENQ: 2
    STACK1: 1   STACK1:     STACK1: 2   STACK1: 1 2
    STACK2:     STACK2: 1   STACK2: 1   STACK2:

    ENQ: 3
    STACK1: 1 2  STACK1:       STACK1: 3     STACK1: 1 2 3
    STACK2:      STACK2: 2 1   STACK2: 2 1   STACK2:

     ENQ: 4
     STACK1: 1 2 3  STACK1:         STACK1: 4       STACK1: 1 2 3 4
     STACK2:        STACK2: 3 2 1   STACK2: 3 2 1   STACK2:
     **/

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
