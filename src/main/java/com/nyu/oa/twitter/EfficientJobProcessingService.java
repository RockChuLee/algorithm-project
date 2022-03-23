package com.nyu.oa.twitter;

//https://leetcode.com/discuss/interview-question/374446/Twitter-or-OA-2019-or-Efficient-Job-Processing-Service
public class EfficientJobProcessingService {

    public static int maximumTotalWeight(int[] weights, int[] tasks, int p) {
        int[][] dp = new int[tasks.length + 1][p / 2 + 1];      // task will be processed double of weight, hence halve p
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < tasks[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1]] + weights[i - 1]);
                }
            }
        }
        return dp[tasks.length][p / 2];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 4, 4, 5};
        int[] tasks = new int[]{2, 2, 3, 4};
        System.out.println(maximumTotalWeight(weights, tasks, 15));      // 10

        weights = new int[]{2, 2, 4, 5};
        tasks = new int[]{2, 2, 3, 4};
        System.out.println(maximumTotalWeight(weights, tasks, 15));      // 9

        weights = new int[]{2};
        tasks = new int[]{2};
        System.out.println(maximumTotalWeight(weights, tasks, 1));      // 0

        weights = new int[]{2};
        tasks = new int[]{2};
        System.out.println(maximumTotalWeight(weights, tasks, 10));      // 2
    }
}
