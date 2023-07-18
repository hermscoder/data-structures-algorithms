package com.hermscoder.datastructure.queue.exercises;

public class Exercise {
    public static void main(String[] args) {
        Queue myQueue = new Queue(2);
        myQueue.enqueue(1);

        // (2) Items - Returns 2 Node
        System.out.println(myQueue.dequeue().value);
        // (1) Item - Returns 1 Node
        System.out.println(myQueue.dequeue().value);
        // (0) Items - Returns null
        System.out.println(myQueue.dequeue());
    }
}

class Queue {

    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        first = last = new Node(value);
        length = 1;
    }

    public void enqueue(int value) {
        Node tmp = new Node(value);

        if(length == 0) {
            first = tmp;
        } else {
            last.next = tmp;
        }

        last = tmp;
        length++;
    }

    public Node dequeue() {
        if (length == 0) return null;

        Node toBeRemoved = first;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            toBeRemoved.next = null;
        }


        length--;
        return toBeRemoved;
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

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

}