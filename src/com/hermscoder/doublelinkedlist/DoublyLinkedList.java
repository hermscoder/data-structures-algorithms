package com.hermscoder.doublelinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node removedNode = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            removedNode.prev = null;
        }
        length--;

        return removedNode;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;
        // If statement to check if we need to start the loop from **start-to-finish** or from the **end-to-beginning**
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
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
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;

        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void swapFirstLast() {
        if (length < 2) return;

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
    }

    public boolean isPalindrome() {
        Node startNode = head;
        Node endNode = tail;
        for (int i = 0; i < length / 2; i++) {

            if (startNode.value != endNode.value) {
                return false;
            }
            startNode = startNode.next;
            endNode = endNode.prev;
        }
        return true;
    }

    public void swapPairs() {
        if(length <= 1) return;

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node first;
        Node second;
        Node prev = dummy;
        while(head != null && head.next != null) {
            first = head;
            second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            second.prev = prev;
            first.prev = second;

            if(first.next != null) {
                first.next.prev = first;
            }

            head = first.next;
            prev = first;
        }
        head = dummy.next;
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

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
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
