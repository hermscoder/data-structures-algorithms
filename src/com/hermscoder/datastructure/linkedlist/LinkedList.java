package com.hermscoder.datastructure.linkedlist;

import java.util.HashSet;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void  append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
        } else {
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;

        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            Node pre = head;
            while(temp.next != null){
                pre = temp;
                temp = temp.next;
            }

            pre.next = null;
            tail = pre;
        }
        length--;
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (length == 0) return null;
        if (index < 0 || index >= length) return null;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();


        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {

        Node temp = head;
        head = tail;
        tail = temp;

        Node after;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public boolean hasLoop() {
        if(length == 0) return false;

        Node fastPointer = head;
        Node slowPointer = head;
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public Node removeKthFromEnd(int k) {
        Node fastPointer = head;
        Node slowPointer = head;

        for(int i = 1; i < k; i++) {
            if(fastPointer == null) return null;
            fastPointer = fastPointer.next;
        }
        Node prev = slowPointer;
        while(fastPointer != null) {
            prev = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        if(prev != null ) {
            prev.next = slowPointer.next;
        }
        return slowPointer;
    }
    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void partitionList(int x) {
        Node left = new Node(0);
        Node right = new Node(0);

        Node leftTail = left;
        Node rightTail = right;

        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            if (temp.value < x) {
                leftTail.next = temp;
                leftTail = leftTail.next;
            } else {
                rightTail.next = temp;
                rightTail = rightTail.next;
            }
            temp.next = null;

            temp = next;
        }


        leftTail.next = right.next;
        rightTail.next = null;
    }

    public void removeDuplicates() {
        HashSet<Integer> set = new HashSet<>();

        Node current = head;
        Node prev = null;
        while(current != null) {
            if(set.contains(current.value)) {
                prev.next = current.next;
                length--;
            } else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
        tail = prev;
    }

    public void reverseBetween(int m, int n) {
        if(head == null || m == n) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;


        for(int i = 0; i < m; i++) {
            prev = prev.next;
        }

        Node current = prev.next;

        for(int i = 0; i < n-m; i++) {
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        head = dummy.next;
        dummy.next = null;
    }


    public void printList() {
        if (length == 0) {
            System.out.println("{} length: 0");
            return;
        }
        var cursor = head;
        var output = new StringBuilder("{");
        while (cursor != null) {
            output.append(cursor.value + (cursor.next != null ? " -> " : ""));
            cursor = cursor.next;
        }
        output.append("} length: " + length);
        System.out.println(output);
    }

    public Node getHead() {
        return head;
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + value + "}";
        }
    }

}

