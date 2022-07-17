package com.nyu.test.weekly9;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        int match = 0;
        int rest = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            match += value / 2;
            if (value % 2 != 0) {
                rest++;
            }
        }
        return new int[]{match, rest};
    }
}
