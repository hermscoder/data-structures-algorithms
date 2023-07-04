package com.hermscoder.hashtable.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }

    public static List<Integer> findDuplicates(int[] array) {
        HashMap<Integer, Integer> presentValuesMap = new HashMap<>();

        for (int value : array) {
            presentValuesMap.put(value, presentValuesMap.getOrDefault(value, 0) + 1);
        }

        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : presentValuesMap.entrySet()) {
            if (entry.getValue() > 1) duplicates.add(entry.getKey());
        }
        return duplicates;
    }

}
