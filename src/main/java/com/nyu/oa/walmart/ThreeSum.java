package com.nyu.oa.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode-cn.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                HashSet<Integer> seen = new HashSet<>();
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.contains(complement)) {
                        res.add(Arrays.asList(nums[i], nums[j], complement));
                        while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                            ++j;
                        }
                    }
                    seen.add(nums[j]);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -nums[i] - nums[j];
                if (seen.contains(complement)) {
                    res.add(Arrays.asList(nums[i], nums[j], complement));

                }
                seen.add(nums[j]);
            }

        }
        return new ArrayList<>(res);
    }
}
