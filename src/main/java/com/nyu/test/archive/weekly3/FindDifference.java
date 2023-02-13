package com.nyu.test.archive.weekly3;

import java.util.*;

public class FindDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> result1 = new HashSet<>();
        Set<Integer> result2 = new HashSet<>();
        for (int i : nums1) {
            result1.add(i);
        }
        for (int j : nums2) {
            result1.remove(j);
            result2.add(j);
        }
        for (int k : nums1) {
            result2.remove(k);
        }
        return Arrays.asList(new ArrayList<>(result1), new ArrayList<>(result2));
    }
}
