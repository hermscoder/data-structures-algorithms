package com.hermscoder.datastructure.heap.exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        MinHeap myHeap = new MinHeap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);
        myHeap.insert(10);
        myHeap.insert(75);

        System.out.println(myHeap.getHeap());

        Integer removedValue1 = myHeap.remove();

        System.out.println("First Removed Value: " + removedValue1);
        System.out.println(myHeap.getHeap());

        Integer removedValue2 = myHeap.remove();

        System.out.println("Second Removed Value: " + removedValue2);
        System.out.println(myHeap.getHeap());

        /*
            EXPECTED OUTPUT:
            ----------------
            [10, 58, 72, 99, 61, 75]
            First Removed Value: 10
            [58, 61, 72, 99, 75]
            Second Removed Value: 58
            [61, 75, 72, 99]
        */
    }
}

class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
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
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = parent(currentIndex);
            if(heap.get(currentIndex) >= heap.get(parentIndex)) break;

            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    public Integer remove(){
        if(heap.size() == 0) return null;
        if(heap.size() == 1) return heap.remove(0);

        int removedValue = heap.get(0);

        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return removedValue;
    }

    private void sinkDown(int index) {
        int minIndex = index;
        while(true) {
            int leftChildIndex = leftChild(minIndex);
            int rightChildIndex = rightChild(minIndex);

            if(leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }

            if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }

            if(minIndex != index) {
                swap(minIndex, index);
                index = minIndex;
            } else {
                return;
            }
        }
    }
}
