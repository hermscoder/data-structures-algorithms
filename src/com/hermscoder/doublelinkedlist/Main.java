package com.hermscoder.doublelinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDll = new DoublyLinkedList(7);
        myDll.getHead();
        myDll.getTail();
        myDll.getLength();

        myDll.append(1);
        myDll.append(2);
        myDll.append(3);
        myDll.printList();

        myDll.removeLast();
        myDll.printList();


        myDll.removeLast();
        myDll.printList();

        myDll.prepend(9);
        myDll.prepend(2);
        myDll.printList();


        myDll.removeFirst();
        myDll.printList();

        myDll.removeFirst();
        myDll.printList();

        myDll.removeFirst();
        myDll.printList();

        myDll.removeFirst();
        myDll.printList();

        myDll.removeFirst();
        myDll.printList();

        myDll.prepend(9);
        myDll.prepend(1);
        myDll.append(2);
        myDll.append(3);
        myDll.append(6);
        myDll.append(12);
        myDll.append(7);
        myDll.printList();


        System.out.println("Node: " + myDll.get(5));
        myDll.printList();

        System.out.println("Node: " + myDll.get(2));
        myDll.printList();

        System.out.println("Set: " + myDll.set(2, 85));
        myDll.printList();

        System.out.println("Insert: " + myDll.insert(2, 84));
        myDll.printList();

        System.out.println("Insert: " + myDll.insert(0, 100));
        myDll.printList();

        System.out.println("Insert: " + myDll.insert(9, 107));
        myDll.printList();

        System.out.println("Remove: " + myDll.remove(0));
        myDll.printList();

        System.out.println("Reverse List ");
        myDll.reverse();
        myDll.printList();

        DoublyLinkedList dll2 = new DoublyLinkedList(1);
        dll2.append(2);
        dll2.append(3);
        dll2.append(2);
        dll2.append(1);
        dll2.printList();
        System.out.println("Palindrome: " + dll2.isPalindrome());

        DoublyLinkedList dll3 = new DoublyLinkedList(1);
        dll3.removeLast();
        dll3.printList();
        System.out.println("Palindrome: " + dll3.isPalindrome());

        DoublyLinkedList dll4 = new DoublyLinkedList(1);
        dll4.append(2);
        dll4.append(3);
        dll4.append(4);
        dll4.printList();
        System.out.println("Swap Pairs");
        dll4.swapPairs();
        dll4.printList();
    }
}
