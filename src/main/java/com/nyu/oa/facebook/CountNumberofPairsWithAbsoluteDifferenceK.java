package com.nyu.oa.facebook;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
public class CountNumberofPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ++res;
                }
            }
        }
        return res;
    }

    public int countKDifference1(int[] nums, int k) {
        int res = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            res += cnt.getOrDefault(nums[i] - k, 0) + cnt.getOrDefault(nums[i] + k, 0);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 4};
        int k = 2;
        CountNumberofPairsWithAbsoluteDifferenceK c = new CountNumberofPairsWithAbsoluteDifferenceK();
        c.countKDifference1(nums, k);
    }
}
