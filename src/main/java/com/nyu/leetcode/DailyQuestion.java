package com.nyu.leetcode;

import java.util.Arrays;

public class DailyQuestion {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        sum = (rolls.length + n) * mean - sum;
        int[] result = new int[n];
        if (sum > n * 6) {
            return result;
        }
        for (int j = 1; j <= sum; j++) {
            result[j % n]++;
        }
        return result;
    }

    public static void main(String[] args) {
        DailyQuestion dailyQuestion = new DailyQuestion();
        System.out.println(Arrays.toString(dailyQuestion.missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
    }
}
