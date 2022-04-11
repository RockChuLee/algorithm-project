package com.nyu.oa.walmart;

//https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {

    //Linear Scan
    // Todo
    // time complexity: O(n)
    // space complexity: O(1)
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    //Binary Search
    //iterator

    // time complexity: O(log2 n)
    // space complexity: O(1)
    public int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    //Binary Search
    //recursion
    // time complexity: O(log2 n)
    // space complexity: O(log2 n)
    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
