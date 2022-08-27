package com.nyu.oa.mathwork;

import java.util.Arrays;

public class ArrayGame {


    public static int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{}));
    }
}
