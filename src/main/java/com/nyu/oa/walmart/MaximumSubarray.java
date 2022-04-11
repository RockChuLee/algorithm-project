package com.nyu.oa.walmart;

import java.util.Arrays;

//https://leetcode-cn.com/problems/maximum-subarray/
public class MaximumSubarray {

    //dp
    // time complexity: O(n)
    // space complexity: O(n)
    public static int maxSubArray1(int[] nums) {
        int[] maxAns = new int[nums.length];
        Arrays.fill(maxAns, Integer.MIN_VALUE);
        maxAns[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            maxAns[i] = Math.max(maxAns[i-1] + x, x);
        }
        return Arrays.stream(maxAns).max().getAsInt();
    }
    //dp
    // time complexity: O(n)
    // space complexity: O(1)
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
