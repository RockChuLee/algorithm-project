package com.nyu.oa.citadel;

public class GlobalMaximum {
    static int GlobalMaxim(int[] arr, int m) {
        int len = arr.length;
        int max = 0;
        int[][] dp = new int[len][len];

        // Iterate through all indices from back
        for (int i = len - 1; i >= 0; i--) {
            dp[i][0] = Integer.MAX_VALUE;
            // Try to get the maximum diff for all possible subsequences of size j starting at k
            for (int j = 1; j < m; j++) {
                // For each valid k, check if after taking the minSubDiff of j-1 starting at k we can maximize dp[i,j]
                for (int k = i + 1; len - j >= k; k++) {
                    dp[i][j] = Math.max(dp[i][j], Math.min(Math.abs(arr[i] - arr[k]), dp[k][j - 1]));
                }
            }
            // Take the maximum dp[i,m-1], meaning the i is the index at which the min-max subsequence starts of size m
            max = Math.max(max, dp[i][m - 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(GlobalMaxim(new int[]{2, 3, 5, 9}, 3));
    }
}
