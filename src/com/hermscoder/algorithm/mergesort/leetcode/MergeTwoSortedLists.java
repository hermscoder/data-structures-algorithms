package com.hermscoder.algorithm.mergesort.leetcode;

/**
 * Description
 * The merge method takes in another LinkedList as an input and merges it with the current LinkedList.
 * The elements in both lists are assumed to be in ascending order, but the input lists themselves do
 * not need to be sorted.
 *
 * Parameters
 * otherList: the other LinkedList to merge with the current list
 *
 * Return Value
 * This method does not return a value, but it modifies the current LinkedList to contain the merged list.
 *
 * Method signature:
 * public void merge(LinkedList otherList)
 *
 * Example:
 * LinkedList l1 = new LinkedList(1);
 * l1.append(3);
 * l1.append(5);
 * l1.append(7);
 *
 * LinkedList l2 = new LinkedList(2);
 * l2.append(4);
 * l2.append(6);
 * l2.append(8);
 *
 * l1.merge(l2);
 *
 * // The current list (l1) now contains the merged list [1, 2, 3, 4, 5, 6, 7, 8]
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);

        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);

        l1.merge(l2);

        l1.printAll();

        /*
            EXPECTED OUTPUT:
            ----------------
            Head: 1
            Tail: 8
            Length:8

            Linked List:
            1
            2
            3
            4
            5
            6
            7
            8

        */

    }
}

class LinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    public LinkedList(int value) {
        ListNode newNode = new ListNode(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getTail() {
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
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.val);
            System.out.println("Tail: " + tail.val);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        ListNode newNode = new ListNode(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void merge(LinkedList otherList) {
        var otherHead = otherList.head;
        var dummy = new ListNode(0);

        var current = dummy;

        var temp = head;
        while(otherHead != null && temp != null) {
            if(temp.val < otherHead.val) {
                current.next = temp;
                temp = temp.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            current = current.next;
        }

        if(temp != null) {
            current.next = temp;
        } else {
            current.next = otherHead;
            tail = otherList.tail;
        }


        head = dummy.next;
        this.length += otherList.length;
    }


}


