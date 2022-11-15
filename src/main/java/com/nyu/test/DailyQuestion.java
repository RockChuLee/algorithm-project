package com.nyu.test;


import java.util.Arrays;
import java.util.Collections;

public class DailyQuestion {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right != nums.length || sum >= target) {
            if (sum < target) {
                sum += nums[right++];
//                System.out.println(1 + ":" + sum);
            } else {
                if (right - left <= minLength) {
                    minLength = right - left;
                }
                sum -= nums[left++];
//                System.out.println(2 + ":" + sum);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int maxRepeating(String sequence, String word) {
        int count = 0;
        for (int i = 0; i <= sequence.length() - word.length(); i++) {
            if (sequence.substring(i, i + word.length()).equals(word)) {
                count++;
                i+=word.length()-1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{};
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
//        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3, 2, 3, 1, 2, 4, 3, 99, 100, 2, 3, 1, 2, 4, 3}));
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
