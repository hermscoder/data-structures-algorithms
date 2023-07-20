package com.hermscoder.algorithm.selectionsort.exercise;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int[] myArray = {4,2,6,5,1,3};

        selectionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */
    }

    public static void selectionSort(int[] array) {
        for (var i = 0; i < array.length - 1; i++) {
            var minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
