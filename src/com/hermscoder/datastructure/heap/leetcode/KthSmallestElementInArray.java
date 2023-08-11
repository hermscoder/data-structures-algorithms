package com.hermscoder.datastructure.heap.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implement a method in Java named findKthSmallest.
 * This method takes two parameters as input: an array of integers nums
 * and an integer k. The array nums can have both positive and negative
 * integers and can be of any size. The integer k is guaranteed to be
 * in the range of 1 to the length of the array inclusive.
 * Your task is to find the kth smallest element in the array nums. In
 * other words, if the elements of the array were sorted in ascending
 * order, the element at the kth position (1-indexed) is the output.
 *
 * Here's the method signature you'll be implementing:
 * public static int findKthSmallest(int[] nums, int k);
 *
 * LeetCode similar:
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 *
 * Input:
 * The first parameter is an array of integers, nums. The array may
 * contain duplicate elements.
 *
 * The second parameter is an integer, k (1 ≤ k ≤ nums.length). This
 * is the position of the element to return if the array was sorted
 * in ascending order.
 *
 * Output:
 * The function must return the kth smallest element in nums.
 *
 * Constraints:
 * You must use a MaxHeap to solve this problem. A Heap class is
 * already provided for you, and you can use its methods to add
 * elements to the heap (insert), remove the maximum element
 * (remove), and get the current size of the heap (getHeap().size()).
 *
 * Your solution should aim for a time complexity better than
 * O(n log n), which would be the case if you sorted the array.
 *
 * Example:
 * int[] nums = {7, 10, 4, 3, 20, 15};
 * int k = 3;
 * System.out.println(findKthSmallest(nums, k));  // Output: 7
 *
 *
 * In the above example, the kth smallest element is 7, which is
 * the 3rd smallest number in the array.
 */
public class KthSmallestElementInArray {
    public static int findKthSmallest2(int[] nums, int k){
        Heap heap = new Heap();
        for (int num : nums) {
            heap.insert(num);
            if(heap.getHeap().size() > k) {
                heap.remove();
            }
        }

        return heap.getHeap().get(0);
    }

    public static int findKthSmallest(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for (int num : nums) {
            heap.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }

        return heap.peek();
    }
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
        System.out.println();


        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Expected output: 7
            Actual output: 7

            Test case 2:
            Expected output: 2
            Actual output: 2

            Test case 3:
            Expected output: 7
            Actual output: 7

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

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }

}