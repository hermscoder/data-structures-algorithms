package com.hermscoder.datastructure.hashtable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public void set(String key, int value) {
        int addressIndex = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[addressIndex] == null) {
            dataMap[addressIndex] = newNode;
        } else {
            Node temp = dataMap[addressIndex];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int addressIndex = hash(key);

        Node temp = dataMap[addressIndex];
        while(temp != null){
            if(key.equals(temp.key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();

        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while(temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    // Node example: { "nails"= 1000 }
    class Node {
        private String key;
        private int value;
        private Node next;
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void printTable() {
        for (int i = 0; i < 7; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.print("\t{ " + temp.key + ":" + temp.value + " }\n");
                temp = temp.next;
            }
        }
    }
}
