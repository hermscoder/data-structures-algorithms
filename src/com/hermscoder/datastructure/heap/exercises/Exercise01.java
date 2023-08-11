package com.hermscoder.datastructure.heap.exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {

        Heap myHeap = new Heap();
        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);
        myHeap.insert(50);
        myHeap.insert(65);

        System.out.println(myHeap.getHeap());

        myHeap.print();
        myHeap.remove();
        myHeap.print();

        System.out.println(myHeap.getHeap());


        myHeap.remove();

        System.out.println(myHeap.getHeap());

        /*
            EXPECTED OUTPUT:
            ----------------
            [95, 75, 80, 55, 60, 50, 65]
            [80, 75, 65, 55, 60, 50]
            [75, 60, 65, 55, 50]

        */

    }
}

class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int num) {
        heap.add(num);

        int currentIndex =heap.size() - 1;

        while(currentIndex >= 0) {
            int parentIndex = parent(currentIndex);

            if(heap.get(parentIndex) >= heap.get(currentIndex)) break;

            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(maxIndex);
            int rightIndex = rightChild(maxIndex);
            if(leftIndex < heap.size() && heap.get(maxIndex) < heap.get(leftIndex)){
                maxIndex = leftIndex;
            }

            if(rightIndex < heap.size() && heap.get(maxIndex) < heap.get(rightIndex)){
                maxIndex = rightIndex;
            }

            if(maxIndex != index) {
                swap(maxIndex, index);
                index = maxIndex;
            } else {
                break;
            }
        }
    }

    public Integer remove() {
        if(heap.size() == 0) return null;
        if(heap.size() == 1) return heap.remove(0);

        int removedItem = heap.get(0);

        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return removedItem;
    }

    public void print() {

        StringBuilder sb = new StringBuilder();

        int currentIndex = 0;
        sb.append("\t\t\t" +heap.get(currentIndex) + "\n");
        int level = 1;
        while(Math.pow(2, level) <= heap.size()) {
            currentIndex = (int) Math.pow(2, level) - 1;

            for (int i = 0; i < 3 - level; i++) {
                sb.append("\t");
            }
            for (int i = 0; i < Math.pow(2, level); i++) {
                if(currentIndex + i < heap.size()) {
                    sb.append(heap.get(currentIndex + i) + "\t\t");
                }
            }
            sb.append("\n");
            level++;
        }
        System.out.println(sb);
    }
}
