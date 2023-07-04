package com.hermscoder.hashtable.leetcode;

import java.util.HashMap;

public class ItemInCommon {

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 1};

        System.out.println(itemInCommon(array1, array2));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap firstValues = new HashMap<Integer, Boolean>();

        for (int value : array1) {
            firstValues.put(value, true);
        }

        for (int value : array2) {
            if (firstValues.get(value) != null) {
                return true;
            }
        }

        return false;
    }
}
