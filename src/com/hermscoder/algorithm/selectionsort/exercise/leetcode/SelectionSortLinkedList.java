package com.hermscoder.algorithm.selectionsort.exercise.leetcode;

/**
 * Selection Sort of LL ( ** Interview Question)
 * Leetcode Similar: https://leetcode.com/problems/sort-list/description/
 * Implement the Selection Sort algorithm on a singly linked list.
 *
 * The linked list has already been defined and contains integer elements.
 *
 * You are required to write a method selectionSort() within the LinkedList
 * class. This method will sort the linked list in ascending order using the
 * Selection Sort algorithm.
 *
 * The Selection Sort algorithm works by dividing the list into a sorted and
 * an unsorted region. The sorted region starts out empty and the unsorted
 * region is initially the entire list. The algorithm repeatedly selects the
 * smallest (or largest, depending on sorting order) element from the
 * unsorted region and moves it into the sorted region. When the unsorted
 * region becomes empty, the algorithm stops and the list is sorted.
 *
 * Here is a brief overview of the steps involved in implementing the
 * selection sort algorithm:
 *
 * Check if the length of the linked list is less than 2. If it is, the list
 * is already sorted, so the method should return immediately.
 *
 * Initialize a Node object current to the head of the list.
 *
 * Set up a while loop that continues as long as current.next is not null.
 *
 * Within this loop, set smallest to current and innerCurrent to the next
 * node in the list.
 *
 * While innerCurrent is not null, if innerCurrent's value is less than
 * smallest's value, set smallest to innerCurrent. Then, advance
 * innerCurrent to the next node.
 *
 * After going through all nodes in the unsorted region, if smallest is not
 * current, swap the values in smallest and current.
 *
 * Move current to the next node and repeat the process until the entire
 * list is sorted.
 *
 * At the end of the sort, update the tail of the list to current.
 *
 * Assume that all values in the list are integers. The selectionSort()
 * method should not return any value; it should sort the linked list
 * in-place. That is, it should modify the original linked list rather
 * than creating and returning a new, sorted list.
 */
public class SelectionSortLinkedList {
    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);



        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.selectionSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();



        /*
            EXPECTED OUTPUT:
            ----------------
            Unsorted Linked List:
            4
            2
            6
            5
            1
            3

            Sorted Linked List:
            1
            2
            3
            4
            5
            6

        */

    }
}

class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public void selectionSort() {
        if (length < 2)
            return;

        Node curr = head;

        while(curr != null){
            Node iter = curr;
            Node min = iter;
            while(iter != null){
                if(iter.value < min.value)
                    min = iter;
                iter = iter.next;
            }
            int temp = curr.value;
            curr.value = min.value;
            min.value = temp;

            curr = curr.next;
        }
    }

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
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
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

    // WRITE SELECTIONSORT METHOD HERE //
    //                                 //
    //                                 //
    //                                 //
    //                                 //
    /////////////////////////////////////

}