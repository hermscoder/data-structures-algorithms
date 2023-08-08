package com.hermscoder.datastructure.array.leetcode;

import java.util.Arrays;

/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Examples:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // Example 1: Simple case with positive and negative numbers
        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubArray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result1);

        // Example 2: Case with a negative number in the middle
        int[] inputCase2 = {1, 2, 3, -4, 5, 6};
        int result2 = maxSubArray(inputCase2);
        System.out.println("Example 2: Input: " + Arrays.toString(inputCase2) + "\nResult: " + result2);

        // Example 3: Case with all negative numbers
        int[] inputCase3 = {-1, -2, -3, -4, -5};
        int result3 = maxSubArray(inputCase3);
        System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nResult: " + result3);

        // Example 4: Case with all positive numbers
        int[] inputCase4 = {1, 2, 3, 4, 5};
        int result4 = maxSubArray(inputCase4);
        System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nResult: " + result4);

        // Example 5: Case with alternating positive and negative numbers
        int[] inputCase5 = {1, -1, 1, -1, 1};
        int result5 = maxSubArray(inputCase5);
        System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nResult: " + result5);

        /*
            EXPECTED OUTPUT:
            ----------------
            Example 1: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
            Result: 6
            Example 2: Input: [1, 2, 3, -4, 5, 6]
            Result: 13
            Example 3: Input: [-1, -2, -3, -4, -5]
            Result: -1
            Example 4: Input: [1, 2, 3, 4, 5]
            Result: 15
            Example 5: Input: [1, -1, 1, -1, 1]
            Result: 1
        */

    }

}
