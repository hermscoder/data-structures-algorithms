package com.hermscoder.datastructure.heap.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Heap: Maximum Element in a Stream
 * Implement a function named streamMax that processes a stream of integers
 * and returns the maximum number encountered so far for each input number.
 *
 * This function should take in an array of integers and return a list of
 * integers.
 *
 * Given an array of integers, your function should iterate over the array
 * and for each number, it should find the maximum number in the array up
 * until that point, including the current number.
 *
 * The streamMax function has the following signature:
 * public static List<Integer> streamMax(int[] nums)
 *
 * It accepts one parameter:
 * nums (an array of integers): An array of integers  for each i from 0
 * to nums.length - 1.
 *
 * The function should return:
 * A list of integers: The i-th integer in the list should be the maximum
 * number among the first i numbers in the input array nums (1-indexed).
 *
 *
 * Here are some examples to demonstrate the expected behavior of the
 * streamMax function:
 *
 * Examples:
 * int[] nums = {1, 5, 2, 9, 3, 6, 8};
 * List<Integer> result = streamMax(nums);
 * // Expected output: [1, 5, 5, 9, 9, 9, 9]
 * // Explanation: The maximum number for the first number is 1,
 * // for the first two numbers is 5, for the first three numbers is 5, and so on.
 *
 * int[] nums = {10, 2, 5, 1, 0, 11, 6};
 * List<Integer> result = streamMax(nums);
 * // Expected output: [10, 10, 10, 10, 10, 11, 11]
 * // Explanation: The maximum number for the first number is 10,
 * // for the first two numbers is 10, for the first three numbers is 10, and so on.
 *
 * int[] nums = {3, 3, 3, 3, 3};
 * List<Integer> result = streamMax(nums);
 * // Expected output: [3, 3, 3, 3, 3]
 * // Explanation: Since all numbers are the same,
 * // the maximum number for any prefix of the input array is always 3.
 */
public class MaximumElementInStream {

    private static List<Integer> streamMax(int[] nums) {
        Heap heap = new Heap();

        heap.insert(nums[0]);
        List<Integer> results= new ArrayList<>();
        results.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            heap.insert(nums[i]);
            results.add(heap.getHeap().get(0));
        }
        return results;
    }
    private static List<Integer> streamMax2(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);

        heap.add(nums[0]);
        List<Integer> results= new ArrayList<>();
        results.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            heap.add(nums[i]);
            results.add(heap.peek());
        }
        return results;
    }


    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();

        // Test case 2
        int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
        System.out.println("Actual output: " + streamMax(nums2));
        System.out.println();

        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Expected output: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums3));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Input: [1, 5, 2, 9, 3, 6, 8]
            Expected output: [1, 5, 5, 9, 9, 9, 9]
            Actual output: [1, 5, 5, 9, 9, 9, 9]

            Test case 2:
            Input: [10, 2, 5, 1, 0, 11, 6]
            Expected output: [10, 10, 10, 10, 10, 11, 11]
            Actual output: [10, 10, 10, 10, 10, 11, 11]

            Test case 3:
            Input: [3, 3, 3, 3, 3]
            Expected output: [3, 3, 3, 3, 3]
            Actual output: [3, 3, 3, 3, 3]

        */
    }

    static class Heap {
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
}


