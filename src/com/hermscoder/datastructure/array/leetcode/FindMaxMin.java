package com.hermscoder.datastructure.array.leetcode;

import java.util.Arrays;

/**
 * Array: Find Max Min
 * In this problem, you are given an array of integers, and the task is to write a
 * method that finds the maximum and minimum numbers in the array.
 *
 * The method should return these two numbers as an array with the maximum number at
 * the first index and the minimum number at the second index.
 *
 * Method Signature
 * public static int[] findMaxMin(int[] myList)
 *
 * This method accepts an integer array myList as the input and returns an integer
 * array of size two.
 *
 *
 *
 * Example
 * Input: myList = [5, 3, 8, 1, 6, 9]
 * Output: [9, 1]
 *
 *
 *
 * The function should iterate through the array to find the maximum and minimum
 * numbers. In this case, the maximum number is 9, and the minimum number is 1.
 * Hence, the method should return [9, 1].
 */
public class FindMaxMin {
    public static int[] findMaxMin(int[] array) {
        int[] maxMinArray = {array[0], array[0]};

        for (int i = 0; i < array.length; i++) {
            if(array[i] > maxMinArray[0]) {
                maxMinArray[0] = array[i];
            }

            if(array[i] < maxMinArray[1]) {
                maxMinArray[1] = array[i];
            }
        }
        return maxMinArray;
    }

    public static void main(String[] args) {

        int[] myList1 = {5, 3, 8, 1, 6, 9};
        int[] result1 = findMaxMin(myList1);
        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"

        int[] myList2 = {-5, -3, -8, -1, -6, -9};
        int[] result2 = findMaxMin(myList2);
        System.out.println("Test case 2: MaxMin: " + Arrays.toString(result2)); // prints "[-1, -9]"

        int[] myList3 = {0, 0, 0, 0, 0};
        int[] result3 = findMaxMin(myList3);
        System.out.println("Test case 3: MaxMin: " + Arrays.toString(result3)); // prints "[0, 0]"

        int[] myList4 = {100, 200, 300, 400, 500};
        int[] result4 = findMaxMin(myList4);
        System.out.println("Test case 4: MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: MaxMin: [9, 1]
            Test case 2: MaxMin: [-1, -9]
            Test case 3: MaxMin: [0, 0]
            Test case 4: MaxMin: [500, 100]
        */

    }
}
