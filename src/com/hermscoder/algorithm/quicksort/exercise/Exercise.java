package com.hermscoder.algorithm.quicksort.exercise;

import java.util.Arrays;

public class Exercise {
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }


    public static void main(String[] args) {

        int[] myArray = {4,6,1,7,3,2,5};

        quickSort(myArray);

        System.out.println( Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7]

         */

    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        if (array.length < 2) return 0;

        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if(array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, swapIndex, pivotIndex);

        return swapIndex;
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }

    public static void quickSortHelper(int[] array, int left, int right) {
        if(left < right) {
            int middleIndex = pivot(array, left, right);

            quickSortHelper(array, left, middleIndex);
            quickSortHelper(array, middleIndex + 1, right);
        }
    }
}
