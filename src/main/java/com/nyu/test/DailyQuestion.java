package com.nyu.test;


public class DailyQuestion {
    public static int waysToMakeFair(int[] nums) {
        int size = nums.length;
        int[] oddSums = new int[size / 2 + 1];
        int[] evenSums = new int[size / 2 + 1];
        int oddSum = 0, evenSum = 0;
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (flag) {
                evenSum += nums[i];
                evenSums[i / 2] = evenSum;
            } else {
                oddSum += nums[i];
                oddSums[i / 2] = oddSum;
            }
            flag = !flag;
        }
        int result = 0;
        for (int i = 0; i < size; i++) {
            int i1 = evenSums[i / 2] + (oddSums[size / 2 ] - oddSums[i / 2 + 1]);
            int i2 = oddSums[i / 2] + (evenSums[size / 2 ] - evenSums[i / 2 + 1]);
            if (i1 == i2) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{2, 1, 6, 4}));
    }
}
