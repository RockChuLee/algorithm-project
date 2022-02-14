package com.nyu.leetcode;

import java.util.Arrays;
import java.util.List;

public class SingleElementinaSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3}));
        System.out.println(4 ^ 2);
    }
}
