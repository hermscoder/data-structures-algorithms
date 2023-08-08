package com.hermscoder.datastructure.array.leetcode;

import java.util.Arrays;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/description/
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are
 * not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you
 * need to do the following things:
 *
 * - Change the array nums such that the first k elements of nums contain the elements which are not
 * equal to val. The remaining elements of nums are not important as well as the size of nums.
 *
 * - Return k.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 *
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 */
public class RemoveElement {

    public static int removeElement(int[] array, int val) {

        int lastNonMatchIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != val) {
                array[lastNonMatchIndex] = array[i];
                lastNonMatchIndex++;
            }
        }
        return lastNonMatchIndex;
    }


    private static void swap(int[]array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,2,2,3,0,4,2};
        int val1 = 2;
        int newLength1 = removeElement(nums1, val1);
        System.out.println("Test case 1: Modified array: " + Arrays.toString(nums1) + "\nNew length: " + newLength1);

//        int[] nums2 = {1, 2, 3, 4, 5, 6};
//        int val2 = 6;
//        int newLength2 = removeElement(nums2, val2);
//        System.out.println("Test case 2: Modified array: " + Arrays.toString(nums2) + "\nNew length: " + newLength2);
//
//        int[] nums3 = {-1, -2, -3, -4, -5};
//        int val3 = -1;
//        int newLength3 = removeElement(nums3, val3);
//        System.out.println("Test case 3: Modified array: " + Arrays.toString(nums3) + "\nNew length: " + newLength3);
//
//        int[] nums4 = {};
//        int val4 = 1;
//        int newLength4 = removeElement(nums4, val4);
//        System.out.println("Test case 4: Modified array: " + Arrays.toString(nums4) + "\nNew length: " + newLength4);
//
//        int[] nums5 = {1, 1, 1, 1, 1};
//        int val5 = 1;
//        int newLength5 = removeElement(nums5, val5);
//        System.out.println("Test case 5: Modified array: " + Arrays.toString(nums5) + "\nNew length: " + newLength5);

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Modified array: [-2, -3, 4, -1, 2, -5, 4, -5, 4]
            New length: 7
            Test case 2: Modified array: [1, 2, 3, 4, 5, 6]
            New length: 5
            Test case 3: Modified array: [-2, -3, -4, -5, -5]
            New length: 4
            Test case 4: Modified array: []
            New length: 0
            Test case 5: Modified array: [1, 1, 1, 1, 1]
            New length: 0
        */

    }
}
