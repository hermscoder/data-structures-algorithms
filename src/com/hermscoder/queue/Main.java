package com.hermscoder.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.printQueue();
        System.out.println("Length: " + queue.getLength());
        System.out.println("First: " + queue.getFirst());
        System.out.println("Last: " + queue.getLast());

        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.printQueue();
        System.out.println("Length: " + queue.getLength());
        System.out.println("First: " + queue.getFirst());
        System.out.println("Last: " + queue.getLast());

        System.out.println("\nDequeuing: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Length: " + queue.getLength());
        System.out.println("First: " + queue.getFirst());
        System.out.println("Last: " + queue.getLast());

        System.out.println("\nDequeuing: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Length: " + queue.getLength());
        System.out.println("First: " + queue.getFirst());
        System.out.println("Last: " + queue.getLast());

        System.out.println("\nDequeuing: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Length: " + queue.getLength());
        System.out.println("First: " + queue.getFirst());
        System.out.println("Last: " + queue.getLast());

        System.out.println("\nDequeuing: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Length: " + queue.getLength());
        System.out.println("First: " + queue.getFirst());
        System.out.println("Last: " + queue.getLast());
    }
}
