package com.hermscoder.datastructure.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(99);
        heap.insert(72);
        heap.insert(61);
        heap.insert(58);

        heap.insert(100);

        heap.print();
    }
}
