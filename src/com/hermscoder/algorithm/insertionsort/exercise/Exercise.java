package com.hermscoder.algorithm.insertionsort.exercise;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int[] myArray = {4,2,6,5,1,3};

        insertionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = i;
            while(index > 0 && array[index - 1] > array[index]) {
                int tmp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = tmp;
                index--;
            }
        }
    }
}
