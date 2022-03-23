package com.nyu.oa.twitter;

import java.util.Arrays;

//https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
public class ArrayGame {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }
}
