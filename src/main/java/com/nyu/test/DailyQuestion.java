package com.nyu.test;


import java.util.Arrays;

public class DailyQuestion {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (long) weights[l] * (long) weights[i - 1]);
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, dp[n][i]);
        }
        return res;
    }
}
