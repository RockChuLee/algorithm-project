package com.nyu.test;

public class DailyQuestion {

    public static int longestConsecutive(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] temp = new int[max + 1];
        for (int num : nums) {
            temp[num] = 1;
        }
        int min = 0;
        int res = 0;
        for (int i = 0; i <= max; i++) {
            if (temp[i] == 1) {
                res++;
            } else {
                min = Math.max(res, min);
                res = 0;
            }
        }
        return res==0?min:res;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
    }
}