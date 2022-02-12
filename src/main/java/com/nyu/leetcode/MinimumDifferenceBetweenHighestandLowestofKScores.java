package com.nyu.leetcode;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestandLowestofKScores {
    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 4, 1, 7};
        int k = 2;
        System.out.println(minimumDifference(nums, 3));
    }
}
