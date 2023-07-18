package com.hermscoder.datastructure.hashtable.leetcode;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));
    }

    public static Character firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> allChars = new HashMap<>();

        for (char c : str.toCharArray()) {
            allChars.put(c, allChars.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (allChars.get(c) == 1) {
                return c;
            }
        }

        return null;
    }
}
