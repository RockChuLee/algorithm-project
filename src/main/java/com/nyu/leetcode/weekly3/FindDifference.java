package com.nyu.leetcode.weekly3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] a1 = Arrays.stream(nums1).distinct().toArray();
        int[] a2 = Arrays.stream(nums2).distinct().toArray();

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        for (int i = 0; i < a1.length; i++) {
            if (!result1.contains(a1[i])) {
                result1.add(a1[i]);
            }
        }

        for (int i = 0; i < a2.length; i++) {
            if (result1.contains(a2[i])) {
                result1.remove(result1.indexOf(a2[i]));
            } else {
                result2.add(a2[i]);
            }
        }
        return Arrays.asList(result1, result2);
    }
}
