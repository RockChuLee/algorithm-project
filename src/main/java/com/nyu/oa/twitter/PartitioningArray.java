package com.nyu.oa.twitter;

import java.util.HashMap;

/**
 * Given an array of numbers you are required to check if it is possible to partition the array into
 * some subsequences of length k each, such that:
 * . Each element in the array occurs in exactly one subsequence
 * . All the numbers in a subsequence are distinct
 * . Elements in the array having the same value must be in different subsequences
 * Is possible to partition the array satisfying the above conditions? if it is possible, return "Yes", else return "No".
 * For example, suppose:
 * . There are n = 4 numbers in the array
 * . The length of each subsequence needs to be k = 2
 * . The given array is {1, 2, 3, 4}.
 * . Then one possible way is to choose the first 2 elements of the array [1,2 as the first subsequence, the next 2 elements f3,4)as the next
 * subsequence.So the answer is Yes.
 * Consider another example:
 * . There are n = 4 numbers in the array,
 * . The length of each subsequence needs to be k = 3.· The given array is {1,2,2，3}.
 * Here there is no way to partion the aray into subsequencs such tht alsubsequence ar eoflength 3 and each element in thearra occurs in xcly one stbseqcuenc. Hfencethe
 * answer is No.
 * Function Description
 * Complete the function solve in the editor below.The function has to return one string denoting the answer.
 * solve has the following parameters:
 * k: an integer
 * numbers[O....,n-1]: an array of integers
 */

//https://leetcode.com/discuss/interview-question/375262/twitter-oa-2019-partitioning-array
public class PartitioningArray {

    public static void main(String[] args) {
        System.out.println(partitionArrayUnique(new int[]{1, 2, 3, 4}, 2)); // true
        System.out.println(partitionArrayUnique(new int[]{1, 2, 3, 3}, 2)); // true
        System.out.println(partitionArrayUnique(new int[]{1, 2, 3, 4}, 3)); // false
        System.out.println(partitionArrayUnique(new int[]{3, 3, 3, 6, 6, 6, 9, 9, 9}, 3)); // true
        System.out.println(partitionArrayUnique(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 2}, 3)); // false
        System.out.println(partitionArrayUnique(new int[]{}, 1)); // true
        System.out.println(partitionArrayUnique(new int[]{1}, 1)); // true
        System.out.println(partitionArrayUnique(new int[]{1, 2}, 2)); // true
    }

    public static boolean partitionArrayUnique(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > max) {
                max = map.get(num);
            }
        }

        return max <= (nums.length / k);
    }
}
