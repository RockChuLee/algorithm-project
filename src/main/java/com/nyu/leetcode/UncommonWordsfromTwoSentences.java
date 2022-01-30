package com.nyu.leetcode;

import java.util.*;

//https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        extracted(s1, map);
        extracted(s2, map);
        List<String> result = new ArrayList<String>();

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }

    private void extracted(String s1, HashMap<String, Integer> map) {
//        String[] arr = s1.split(" ");
        int start = 0;
        int length = s1.length();
        int end = length;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == ' ') {
                end = i;
                String substring = s1.substring(start, end);
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                start = i + 1;
            } else if (i == length - 1) {
                String substring = s1.substring(start, length);
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("0123456789".substring(0,3));
    }
}
