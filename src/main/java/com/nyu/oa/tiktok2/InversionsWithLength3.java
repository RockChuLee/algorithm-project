package com.nyu.oa.tiktok2;

// https://leetcode.com/discuss/interview-question/777188/find-size-3-inversions-in-a-list
public class InversionsWithLength3 {

    public static void main(String[] args) {
        System.out.println(solveMain(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solveMain(new int[]{1, 2, 3, 5, 4}));
        System.out.println(solveMain(new int[]{5, 8, 6, 1, 4, 5}));

        // extension
        System.out.println(solveMain(new int[]{1, 2, 3, 4, 5}, 4));
    }

    public static int solveMain(int[] arr) {
        return solveMain(arr, 3);
    }

    public static int solveMain(int[] arr, int k) {
        int sol = 0;
        Integer[][] dp = new Integer[arr.length][k + 1];
        for (int i = 0; i < arr.length; ++i)
            sol += solve(arr, i, k - 1, dp);
        return sol;
    }

    public static int solve(int[] arr, int index, int nums, Integer[][] dp) {
        if (nums == 0) return 1;
        if (index >= arr.length) return 0;
        if (dp[index][nums] != null) return dp[index][nums];
        // use arr[index]
        int sol = 0;
        for (int i = index + 1; i < arr.length; ++i) {
            if (arr[i] < arr[index])
                sol += solve(arr, i, nums - 1, dp);
        }
        dp[index][nums] = sol;
        return sol;
    }
}
