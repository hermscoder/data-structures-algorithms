package com.hermscoder.queue;


public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        first = last = new Node(value);
        length = 1;
    }

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

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.print('\n');
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void enqueue(int value) {
        var newNode = new Node(value);
        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if (length == 0) return null;

        Node toBeDequeued = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            toBeDequeued.next = null;
        }
        length--;
        return toBeDequeued;
    }
}