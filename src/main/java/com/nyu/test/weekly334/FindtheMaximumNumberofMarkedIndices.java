package com.nyu.test.weekly334;

import java.util.Arrays;

public class FindtheMaximumNumberofMarkedIndices {

    // two point
    // time complexity: nlogn
    // space complexity: 1
    public int maxNumOfMarkedIndices2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        for (int j = (n + 1) / 2; j < n; j++) {
            if (nums[i] * 2 <= nums[j]) {
                i++;
            }
        }
        return i * 2;
    }

    // binary
    // time complexity: nlogn
    // space complexity: 1
    public int maxNumOfMarkedIndices3(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length / 2 + 1; // 开区间
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) left = mid;
            else right = mid;
        }
        return left * 2;
    }

    public boolean check(int[] nums, int k) {
        for (int i = 0; i < k; ++i)
            if (nums[i] * 2 > nums[nums.length - k + i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
