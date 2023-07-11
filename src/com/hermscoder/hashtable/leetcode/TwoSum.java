package com.hermscoder.hashtable.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem:
 * Given an array of integers nums and a target integer target,
 * find the indices of two numbers in the array that add up to the target.
 *
 * @Input: nums: An array of integers
 * target: A target integer
 * @Output: An array of two integers representing the indices of the two numbers in
 * the input array nums that add up to the target. If no two numbers in the
 * input array add up to the target, return an empty array [].
 * @Return: int[]
 * <p>
 * Examples:
 * Input: int[] nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: The numbers at indices 0 and 1 in the array add up to the target 9.
 * <p>
 * Input: int[] nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 * Explanation: The numbers at indices 1 and 2 in the array add up to the target 6.
 * <p>
 * Input: int[] nums = [1, 2, 3, 4, 5], target = 10
 * Output: []
 * Explanation: There are no two numbers in the array add up to the target 10.
 * <p>
 * Input: int[] nums = [], target = 0
 * Output: []
 * Explanation: There are no numbers in the input array, so the function returns an empty array [].
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
