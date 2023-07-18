package com.hermscoder.algorithm.bubblesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
