package com.nyu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> results = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return results;
    }

    public static void dfs(int[] nums, List<Integer> result) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int num : nums) {
            if (result.contains(num)) {
                continue;
            }
            result.add(num);
            dfs(nums, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }
}
