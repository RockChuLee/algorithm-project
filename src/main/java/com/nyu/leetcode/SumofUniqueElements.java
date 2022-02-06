package com.nyu.leetcode;

import java.util.HashMap;
import java.util.Map;

//leetcode-cn.com/problems/sum-of-unique-elements/solution/wei-yi-yuan-su-de-he-by-leetcode-solutio-tueh/
public class SumofUniqueElements {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int num = entry.getKey(), c = entry.getValue();
            if (c == 1) {
                ans += num;
            }
        }
        return ans;
    }
}
