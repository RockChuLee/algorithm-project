package com.nyu.oa.twitter;

import java.util.Arrays;

//https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/submissions/
public class UniqueTwitterUserIdSet {
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, taken = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                taken++;
                ans -= nums[i];
            } else {
                int give = Math.min(taken, nums[i] - nums[i - 1] - 1);
                ans += give * (give + 1) / 2 + give * nums[i - 1];
                taken -= give;
            }
        }

        if (nums.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{3, 1, 2, 2}));
    }
}
