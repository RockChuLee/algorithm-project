package com.nyu.test.weekly312;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int res = 0;
        int maxRes = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        for (int num : nums) {
            if (max < num) {
                max = num;
                res = 1;
                maxRes = 1;
            } else if (max == num) {
                res++;
                maxRes = Math.max(res, maxRes);
            } else {
                res = 0;
            }
        }
        return maxRes;
    }
}
