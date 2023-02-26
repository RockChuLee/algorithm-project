package com.nyu.test;

import java.util.Arrays;

class DailyQuestion {

    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int b = 0;
        int g = (n + 1) / 2;
        while (g < n) {
            if (nums[b] * 2 <= nums[g]) b++;
            g++;
        }
        return 2 * b;
    }


    public static void main(String[] args) {
        DailyQuestion dailyQuestion = new DailyQuestion();
//        dailyQuestion.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        dailyQuestion.maxNumOfMarkedIndices(new int[]{42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40});
        System.out.println(dailyQuestion.maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
    }

}

