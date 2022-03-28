package com.nyu.leetcode.weekly3;

public class MinDeletion {
    public static int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] == nums[i + 1]) ans++;
            else i++;
        }
        if ((n - ans) % 2 !=0) ans++;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDeletion(new int[]{1, 1, 2,  3, 5}));
    }
}
