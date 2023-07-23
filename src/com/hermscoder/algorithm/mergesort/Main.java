package com.hermscoder.algorithm.mergesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] merge = MergeSort.mergeSort(new int[] {3, 1, 4, 2});
        System.out.println(Arrays.toString(merge));
    }
}
