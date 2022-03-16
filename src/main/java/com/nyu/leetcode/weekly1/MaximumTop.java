package com.nyu.leetcode.weekly1;

public class MaximumTop {
    public static int maximumTop(int[] nums, int k) {
        int high = 0;
        int n = nums.length;
        if (nums.length == 1) {
            if (k % 2 == 1) {
                return -1;
            } else {
                return nums[0];
            }
        }
        int i = 0;
        while (i<Math.min(k-1,n)){
            high = Math.max(high, nums[i]);
            i++;
        }
        if(k>=n){
            return high;
        }else {
            return Math.max(high, nums[k]);
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumTop(new int[]{99, 95, 68, 24, 18}, 69));

    }
}
