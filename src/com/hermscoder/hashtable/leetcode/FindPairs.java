package com.hermscoder.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *   Given two integer arrays arr1 and arr2, and an integer target, write a
 * method named findPairs that finds all pairs of integers such that one
 * integer is from arr1, the other is from arr2, and their sum equals the
 * target value.
 *   The method should return a list of integer arrays, each containing a
 * pair of integers.
 *
 *
 * Method signature:
 * public static List<int[]> findPairs(int[] arr1, int[] arr2, int target)
 *
 * Input:
 * arr1: An integer array
 * arr2: An integer array
 * target: An integer value
 *
 * Output:
 * Return a list of integer arrays, where each array contains a pair of
 * integers, one from arr1 and the other from arr2, that sum up to the
 * target value.
 *
 * Example:
 * int[] arr1 = {1, 2, 3, 4, 5};
 * int[] arr2 = {2, 4, 6, 8, 10};
 * int target = 7;
 * List<int[]> pairs = findPairs(arr1, arr2, target);
 *
 * Expected output:
 * [5, 2]
 * [3, 4]
 * [1, 6]
 *
 * In the given example,the method should return a list containing three integer arrays representing the pairs of integers from arr1 and arr2 that sum up to the target value 7.
 */
public class FindPairs {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> mySet = new HashSet<>();
        List<int[]> resultPairs = new ArrayList<>();

        for (int number1 : arr1) {
            mySet.add(number1);
        }

        for (int num : arr2) {
            int complement = target - num;
            if(mySet.contains(complement)) {
                resultPairs.add(new int[] { complement, num });
            }
        }

        return resultPairs;
    }

}
