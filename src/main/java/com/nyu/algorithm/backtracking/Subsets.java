package com.nyu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // The idea is to have two conditions:
    // One in which we will take the element into consideration,
    // Second in which we won't take the element into consideration.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(ans, 0, nums, list);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int start, int[] nums, List<Integer> list
    ) {
        if (start >= nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            // add the element and start the  recursive call
            list.add(nums[start]);
            backtracking(ans, start + 1, nums, list);
            // remove the element and do the backtracking call.
            list.remove(list.size() - 1);
            backtracking(ans, start + 1, nums, list);
        }
    }


}
