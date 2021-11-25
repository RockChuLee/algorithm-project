package com.nyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An array is said to be analogous to the secret array if all of the following conditions are true:
 * • The length of the array is equal to the length of the secret array.
 * • Each integer in the array lies in the interval [lowerBound, upperBound].
 * • The difference between each pair of consecutive integers of the array must be equal to the difference between the respective pair of consecutive integers in the secret array. In other words, let the secret array be [s[0], s[1],..., s[n-1]] and let the analogous array be [PivotIndex[0], PivotIndex[1],..., PivotIndex[n-1]], then (PivotIndex[i-1] - PivotIndex[i]) must be equal to (s[i-1] - s[i]) for each i from 1 to n -1.
 *
 * Given the value of integers lowerBound and upperBound, inclusive, and the array of differences between each pair of consecutive integers of the secret array, find the number of arrays that are analogous to the secret array. If there is no array analogous to the secret array, return 0.
 *
 * For example:
 * consecutiveDifference = [-2, -1, -2, 5]
 * lowerBound = 3
 * upperBound = 10
 *
 * Note that none of the values is out of the bound. All possible analogous arrays are:
 * [3, 5, 6, 8, 3]
 * [4, 6, 7, 9, 4]
 * [5, 7, 8, 10, 5]
 *
 * Tha answer is 3.
 */
public class CountAnalogousArrays {
    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound ) {
        int count = 0;
        int min = lowerBound, max = lowerBound;
        int prev = lowerBound, curr = 0;
        for (int i = 1; i <= consecutiveDifference.size(); i++) {
            curr = prev - consecutiveDifference.get(i - 1);
            min = Math.min(min, curr);
            max = Math.max(max, curr);
            prev = curr;
        }

        while (max <= upperBound) {
            if (min >= lowerBound) count++;
            min = min + 1;
            max = max + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> consecutiveDifference = Arrays.asList(-2, -1, -2, 5);
        System.out.println(countAnalogousArrays(consecutiveDifference, 3, 10));
    }
}
