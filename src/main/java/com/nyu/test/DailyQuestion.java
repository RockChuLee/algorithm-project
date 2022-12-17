package com.nyu.test;


public class DailyQuestion {

    public boolean canChoose(int[][] groups, int[] nums) {
        int n = 0;
        int g = 0;
        while (g < groups.length && n < nums.length) {
            int[] group = groups[g];
            int index = 0;
            if (nums[n] == group[index]) {
                index++;
                if (index == group.length) {
                    g++;
                    index = 0;
                    break;
                }
            } else {
                index = 0;
            }
            n++;

        }
        return g == groups.length;
    }

    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3, 2, 3, 1, 2, 4, 3, 99, 100, 2, 3, 1, 2, 4, 3}));
//        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
