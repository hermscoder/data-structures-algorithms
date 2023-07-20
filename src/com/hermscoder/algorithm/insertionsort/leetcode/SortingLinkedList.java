package com.hermscoder.algorithm.insertionsort.leetcode;

public class SortingLinkedList {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);


        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.insertionSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();

    }
}

class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(" " + temp.value+ ", ");
            temp = temp.next;
        }
        System.out.print("]\n");
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void insertionSort() {
        if( head == null ){
            return;
        }

        Node dummy = new Node(-1);
        dummy.next = head;

        Node curr = head;
        Node numInsert, prev;

        while(curr != null && curr.next != null) {
            if(curr.value <= curr.next.value) {
                curr = curr.next;
            } else {
                numInsert = curr.next;
                prev = dummy;

                while(prev.next.value < numInsert.value) {
                    prev = prev.next;
                }

                curr.next = numInsert.next;
                numInsert.next = prev.next;
                prev.next = numInsert;
            }
        }
        head = dummy.next;
    }

    public void insertionSortBruteForce() {
        if(length < 2) return;

        LinkedList sortedLinkedList = new LinkedList(head.value);
        Node unsortedListHead = head.next;
        while(unsortedListHead != null){
            if(unsortedListHead.value < sortedLinkedList.head.value) {
                Node tmp = sortedLinkedList.head;
                sortedLinkedList.head = new Node(unsortedListHead.value);
                sortedLinkedList.head.next = tmp;
                sortedLinkedList.length++;
            } else {
                Node prevTemp = sortedLinkedList.head;
                Node temp = prevTemp.next;
                boolean addNode = false;
                while(temp != null) {
                    if(unsortedListHead.value < temp.value) {
                        Node newNode = new Node(unsortedListHead.value);
                        prevTemp.next = newNode;
                        newNode.next = temp;
                        sortedLinkedList.length++;
                        addNode = true;
                        break;
                    }
                    prevTemp = temp;
                    temp = temp.next;
                }
                if(!addNode) {
                    Node newNode = new Node(unsortedListHead.value);
                    prevTemp.next = newNode;
                    newNode.next = null;
                    sortedLinkedList.length++;
                }
            }
            unsortedListHead = unsortedListHead.next;
        }
        head = sortedLinkedList.head;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }
}
