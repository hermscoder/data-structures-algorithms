package com.hermscoder.algorithm.selectionsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
        SelectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
