package com.nyu.oa.twitter;

//https://leetcode.com/discuss/interview-question/278341/Uber-phone-interview-Number-of-distinct-subarrays-with-at-most-k-odd-elements/265140

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, find number of distinct contiguous subarrays with at
 * most k odd elements. Two subarrays are distinct when they have at least one different element.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3, 2, 3, 4], k = 1
 * Output: 7
 * Explanation: [3], [2], [4], [3, 2], [2, 3], [3, 4], [2, 3, 4]
 * Note we did not count [3, 2, 3] since it has more than k odd elements.
 * Example 2:
 * <p>
 * Input: nums = [1, 3, 9, 5], k = 2
 * Output: 7
 * Explanation: [1], [3], [9], [5], [1, 3], [3, 9], [9, 5]
 * Example 3:
 * <p>
 * Input: nums = [3, 2, 3, 2], k = 1
 * Output: 5
 * Explanation: [3], [2], [3, 2], [2, 3], [2, 3, 2]
 * [3], [2], [3, 2] - duplicates
 * [3, 2, 3], [3, 2, 3, 2] - more than k odd elements
 * Example 4:
 * <p>
 * Input: nums = [2, 2, 5, 6, 9, 2, 11, 9, 2, 11, 12], k = 1
 * Output: 18
 */
public class EvenSubarray {
    public int distinctSubarraysAtMostKOdd(int[] nums, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < nums.length; i++) {
            int oddCount = 0;
            sb.setLength(0);
            for (int j = i; j < nums.length; j++) {
                if (isOdd(nums[j])) {
                    oddCount++;
                }

                if (oddCount > k)
                    break;

                sb.append("{").append(nums[j]).append("},");
                set.add(sb.toString());
            }
        }

        return set.size();
    }

    private boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    public static void main(String[] args) {
        test(new int[]{3, 2, 3, 2}, 1, 5);
        test(new int[]{3, 2, 3, 4}, 1, 7);
        test(new int[]{1, 3, 9, 5}, 2, 7);
        test(new int[]{2, 2, 5, 6, 9, 2, 11, 9, 2, 11, 12}, 1, 18);
    }

    private static void test(int[] nums, int k, int expected) {
        EvenSubarray sol = new EvenSubarray();
        int actual = sol.distinctSubarraysAtMostKOdd(nums, k);
        if (actual == expected) {
            System.out.println(actual);
        } else {
            throw new AssertionError(String.format("Expected %d, but actual %d", expected, actual));
        }
    }
}