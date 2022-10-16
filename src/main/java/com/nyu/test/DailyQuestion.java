package com.nyu.test;


public class DailyQuestion {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Long ans = 0L;
        int n = nums.length, minI = -1, maxI = -1, i0 = -1;
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            if (x == minK) minI = i;
            if (x == maxK) maxI = i;
            if (x < minK || x > maxK) i0 = i; // 子数组不能包含 nums[i0]
            ans += Math.max(Math.min(minI, maxI) - i0, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
