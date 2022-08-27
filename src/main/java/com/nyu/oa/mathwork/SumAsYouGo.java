package com.nyu.oa.mathwork;

public class SumAsYouGo {
    public static void main(String[] args) {
        int[] nums1 = {10, -20,-5};
        int k1 = 2;
        int[] nums2 = {3,
                -4,
                -3,
                -5,
                0};
        int k2 = 2;
//        System.out.println(getMaxSumDp(nums1, k1));
        System.out.println(getMaxSumDp(nums2, k2));
    }


    private static int getMaxSumDp(int[] nums, int k) {
        int[][] dp = new int[nums.length][nums.length];
        for (int l = 0; l < nums.length; l++) {
            for (int i = 0; i + l < dp.length; i++) {
                if (l == 0) {
                    dp[i][i] = nums[i];
                    continue;
                } else {
                    dp[i][i + l] = Math.min(nums[i] + dp[i + 1][i + l], nums[i + l] + dp[i][i + l - 1]);
                }
            }
        }
        int sum = 0;
        for (int n : nums)
            sum += n;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i + nums.length - k < nums.length; i++) {
            res = Math.max(res, sum - dp[i][i + nums.length - k - 1]);
        }
        return res;
    }
}
