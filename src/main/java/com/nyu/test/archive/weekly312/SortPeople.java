package com.nyu.test.archive.weekly312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int length = names.length;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        for (int i = 0; i < length; i++) {
            names[length - 1 - i] = map.get(heights[i]);
        }
        return names;
    }
}
