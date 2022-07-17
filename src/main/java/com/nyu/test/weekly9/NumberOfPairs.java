package com.nyu.test.weekly9;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        int pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            pairs += value / 2;
        }
        return new int[]{pairs, nums.length - pairs * 2};
    }
}
