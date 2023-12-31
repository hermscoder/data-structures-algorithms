package com.hermscoder.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    public void insert(int num){
        heap.add(num);

        int currentIndex = heap.size() - 1;
        if(heap.size() >= 2) {
            while(currentIndex > 0) {
                int parentIndex = parent(currentIndex);
                if(heap.get(currentIndex) <= heap.get(parentIndex)) break;
                swap(parentIndex, currentIndex);
                currentIndex = parentIndex;
            }
        }
    }

    public Integer remove() {
        if(heap.size() == 0) return null;
        if(heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while(maxIndex < heap.size()) {
            int leftChildIndex = leftChild(maxIndex);
            int rightChildIndex = rightChild(maxIndex);

            if(leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }

            if(maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
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
}
