package com.nyu.leetcode.weekly3;

public class MinDeletion {
    public static int minDeletion(int[] nums) {
        int sum = 0;
        boolean index = nums.length % 2 == 0;
        int i = 0;
        while (i < nums.length-1) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num) {
                    sum++;
                    i = j + 1;
                    index = !index;
                } else {
                    i = j + 1;
                    break;
                }
            }
        }
        if (!index) {
            sum += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minDeletion(new int[]{1, 1, 2,  3, 5}));
    }
}
