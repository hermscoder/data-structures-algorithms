package com.hermscoder.algorithm.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if(array.length == 1) return array;

        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static int[] merge(int[] array1, int[] array2) {
        var combinedArray = new int[array1.length + array2.length];
        var ar1Index = 0;
        var ar2Index = 0;
        var index = 0;
        while (ar1Index < array1.length && ar2Index < array2.length) {
            // Comparing the Z index element of the first array, with the Z index
            // element of the second array
            if(array1[ar1Index] < array2[ar2Index]) {
                // The smaller number will be pushed into the combined array.
                combinedArray[index] = array1[ar1Index];
                ar1Index++;
            } else {
                // The smaller number will be pushed into the combined array.
                combinedArray[index] = array2[ar2Index];
                ar2Index++;
            }
            index++;
        }

        // When there is just one array left, we loop through the elements
        // pushing every element to the new combined array.
        while(ar1Index < array1.length) {
            combinedArray[index] = array1[ar1Index];
            ar1Index++;
            index++;
        }
        // When there is just one array left, we loop through the elements
        // pushing every element to the new combined array.
        while(ar2Index < array2.length) {
            combinedArray[index] = array2[ar2Index];
            ar2Index++;
            index++;
        }
        return combinedArray;
    }
}
