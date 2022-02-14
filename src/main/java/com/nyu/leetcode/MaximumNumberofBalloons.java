package com.nyu.leetcode;

import java.util.*;

public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        int min = Integer.MAX_VALUE;
        List<Character> target = Arrays.asList('b', 'a', 'l', 'o', 'n');
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            if (target.contains(c)) {
                result.put(c, result.getOrDefault(c, 0) + 1);
            }
        }

        if (result.size() != 5) {
            return 0;
        }

        Set<Map.Entry<Character, Integer>> entries = result.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            char key = entry.getKey();
            if (key == 'l' || key == 'o') {
                value = value / 2;
            }
            min = Math.min(min, value);
        }
        return min;
    }
}
