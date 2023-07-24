package com.hermscoder.algorithm.mergesort.exercise;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "Original Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]

            Sorted Array: [1, 2, 3, 4]

         */
    }

    private static int[] mergeSort(int[] array1) {
        if(array1.length < 2) return array1;
        int midIndex = array1.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array1, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array1, midIndex, array1.length));

        return merge(left, right);
    }

    private static int[] merge(int[] array1, int[] array2) {
        var combinedSortedArray = new int[array1.length + array2.length];

        int index;
        int index1 = 0;
        int index2 = 0;
        for (index = 0; index1 < array1.length && index2 < array2.length; index++) {
            if(array1[index1] <= array2[index2]) {
                combinedSortedArray[index] = array1[index1];
                index1++;
            } else {
                combinedSortedArray[index] = array2[index2];
                index2++;
            }
        }

        while(index1 < array1.length) {
            combinedSortedArray[index] = array1[index1];
            index1++;
            index++;
        }

        while(index2 < array1.length) {
            combinedSortedArray[index] = array2[index2];
            index2++;
            index++;
        }
        return combinedSortedArray;
    }
}
