package com.nyu.leetcode;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= k; j++) {
                if ( i + j > length - 1) {
                    break;
                }
                if (nums[i] == nums[i + j]) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
