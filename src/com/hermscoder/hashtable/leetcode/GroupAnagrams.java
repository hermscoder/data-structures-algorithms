package com.hermscoder.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
    }

    public static List<List<String>> groupAnagrams(String[] strings) {


        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String word : strings) {
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            var orderedStr = new String(wordChars);
            List<String> list = hashMap.get(orderedStr);
            if (list != null) {
                list.add(word);
            } else {
                hashMap.put(orderedStr, new ArrayList<>() {{
                    add(word);
                }});
            }
        }


        return new ArrayList<>(hashMap.values());
    }

}
