package com.hermscoder.hashtable;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        Hashtable<Integer, Boolean> hs = new Hashtable();
        for (int i : array1) {
            hs.put(i, true);
        }
        for (int j : array2) {
            if(hs.get(j) != null) return true;
        }
        return false;
    }
}

/* EXPECTED OUTPUT

0:
1:
2:
3:
	{ screws:140 }
4:
	{ bolts:200 }
5:
6:
	{ nails:100 }
	{ tile:50 }
	{ lumber:80 }
Keys:
[screws, bolts, nails, tile, lumber]
 */