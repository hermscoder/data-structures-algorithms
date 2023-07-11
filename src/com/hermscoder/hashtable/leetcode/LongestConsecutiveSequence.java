package com.hermscoder.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, write a function that finds the length of the
 * longestConsecutiveSequence (i.e., a sequence of integers in which each element is
 * one greater than the previous element).
 * Use sets to optimize the runtime of your solution.
 * <p>
 * Input:
 * An unsorted array of integers, nums.
 * <p>
 * Output:
 * An integer representing the length of the longest consecutive sequence in nums.
 * <p>
 * Example:
 * Input:
 * int[] nums = [100, 4, 200, 1, 3, 2]
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation: The longest consecutive sequence in the input array is [4, 3, 2, 1],
 * and its length is 4.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {102, 4, 100, 1, 101, 3, 2, 1, 1};
        int longest = longestConsecutiveSequence(nums);
        System.out.println(longest);
        /*
            EXPECTED OUTPUT:
            ----------------
            4

        */
    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int biggestCount = Integer.MIN_VALUE;
        int currentCount = 0;
        int currentNumber = 0;
        for (int num : nums) {
            // if set contains the previous, we don't start counting yet
            // because we want to start counting when there is no previous
            // meaning that it is the first number of a consecutive sequence.
            if(set.contains(num-1)) {
               // we ignore and move to the next number as we know the previous
               // number is in the set.

            } else {
                currentNumber = num;
                currentCount = 1;
                // if there is no previous, we start counting up.
                while(set.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentCount ++;
                }
                biggestCount = Math.max(currentCount, biggestCount);
            }
        }
        return biggestCount;
    }

}
