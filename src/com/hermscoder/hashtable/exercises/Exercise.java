package com.hermscoder.hashtable.exercises;

import java.util.ArrayList;

public class Exercise {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();

        myHashTable.set("paint", 20);
        myHashTable.set("bolts", 40);
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        System.out.println( myHashTable.keys() );

    }
}

class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList();

        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while(temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public int get(String key) {
        int dataMapIndex = hash(key);

        Node temp = dataMap[dataMapIndex];
        while(temp != null) {
            if(key.equals(temp.key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public void set(String key, int value) {
        Node newNode = new Node(key, value);
        int dataMapIndex = hash(key);

        if(dataMap[dataMapIndex] == null) {
            dataMap[dataMapIndex] = newNode;
        } else {
            Node temp = dataMap[dataMapIndex];

            if (temp.key.equals(key)) {
                temp.value += value;
                return;
            }

            while (temp.next != null) {
                temp = temp.next;
                if (temp.key.equals(key)) {
                    temp.value += value;
                    return;
                }
            }
            temp.next = newNode;
        }
    }

    public int hash(String key) {
        int hash = 0;

        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int asciiValue = chars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    class Node{
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }
}
