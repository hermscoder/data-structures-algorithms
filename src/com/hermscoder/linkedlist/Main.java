package com.hermscoder.linkedlist;

import com.hermscoder.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(11);

        System.out.println("\nLinked List:");

        list.append(3);
        list.append(23);
        list.append(7);
        list.printList();

        list.getHead();
        list.getTail();
        list.getLength();

        LinkedList.Node removedNode = list.removeLast();
        System.out.println(String.format("Removing %s", removedNode));
        list.printList();

        list.prepend(21);
        list.printList();

        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.printList();

        list.prepend(7);
        list.prepend(23);
        list.prepend(3);
        list.prepend(11);
        list.printList();

        list.removeFirst();
        list.printList();

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.printList();

        list.prepend(7);
        list.printList();
        System.out.println(list.get(0));
        list.prepend(23);
        list.prepend(3);
        list.prepend(11);
        list.printList();
        System.out.println(list.get(2));

        list.set(2,99);
        list.printList();

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.set(0,99);
        list.printList();

        list.prepend(23);
        list.prepend(3);
        list.prepend(11);
        list.printList();

        list.insert(1, 100);
        list.printList();

        list.remove(2);
        list.printList();

        list.prepend(12);
        list.prepend(86);
        list.prepend(2);
        list.printList();

        list.reverse();
        list.printList();

        list.removeLast();
        list.printList();


        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(3);

        System.out.println("LL before insert():");
        myLinkedList.printList();

        myLinkedList.insert(1, 2);

        System.out.println("\nLL after insert(2) in middle:");
        myLinkedList.printList();

        myLinkedList.insert(0, 0);

        System.out.println("\nLL after insert(0) at beginning:");
        myLinkedList.printList();

        myLinkedList.insert(4, 4);

        System.out.println("\nLL after insert(4) at end:");
        myLinkedList.printList();
        System.out.println("\n");

        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.printList();

        LinkedList.Node result = myList.removeKthFromEnd(2); // Output: Node with value 4
        System.out.println("2 Kth node: " + result);

        result = myList.removeKthFromEnd(5); // Output: Node with value 1
        System.out.println("5 Kth node: " + result);

        result = myList.removeKthFromEnd(6); // Output: null
        System.out.println("6 Kth node: " + result);

        System.out.println("\n");
        // Create a linked list with values 1, 2, 3, 4, and 5
        LinkedList myLinkedList2 = new LinkedList(1);
        myLinkedList2.append(2);
        myLinkedList2.append(3);
        myLinkedList2.append(4);
        myLinkedList2.append(5);

        System.out.println("Original linked list: ");
        myLinkedList2.printList();

        // Reverse a sublist within the linked list
        myLinkedList2.reverseBetween(1, 3);
        System.out.println("\nReversed sublist (1, 3): ");
        myLinkedList2.printList();

        // Reverse another sublist within the linked list
        LinkedList myLinkedList4 = new LinkedList(1);
        myLinkedList4.append(2);
        myLinkedList4.append(3);
        myLinkedList4.append(4);
        myLinkedList4.append(5);
        myLinkedList4.reverseBetween(0, 4);
        System.out.println("\nReversed entire linked list: ");
        myLinkedList4.printList();

        // Reverse a sublist of length 1 within the linked list
        myLinkedList2.reverseBetween(2, 2);
        System.out.println("\nReversed sublist of length 1 (2, 2): ");
        myLinkedList2.printList();

        // Reverse an empty linked list
        LinkedList emptyList = new LinkedList(0);
        emptyList.makeEmpty();
        emptyList.reverseBetween(0, 0);
        System.out.println("\nReversed empty linked list: ");
        emptyList.printList();

        LinkedList myList3 = new LinkedList(1);
        myList3.append(2);
        myList3.append(3);
        myList3.append(4);
        myList3.append(5);
        myList3.printList();

        System.out.println("\nRemove Kth FromEnd: ");
        myList3.removeKthFromEnd(2);
        myList3.printList();
    }

}
