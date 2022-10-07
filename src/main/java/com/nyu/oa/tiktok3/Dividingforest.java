package com.nyu.oa.tiktok3;

import java.util.List;

public class Dividingforest {
    public static long dividing_forest(List<List<Integer>> forest, int number) {
        int row = forest.size();
        int col = forest.get(0).size();
        long mod = 1000000007L;
        int[][] sub = new int[row + 1][col + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int temp = forest.get(i).get(j) == 2 ? 1 : 0;
                sub[i][j] = sub[i + 1][j] + sub[i][j + 1] - sub[i + 1][j + 1] + temp;
            }
        }
        long[][][] dp = new long[number][row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                dp[0][i][j] = sub[i][j] > 0 ? 1L : 0L;
            }
        }
        for (int o = 1; o < number; o++) {
            for (int j = col - 2; j >= 0; j--) {
                for (int h = 1; h + j < col; h++)
                    dp[o][row - 1][j] += sub[row - 1][j] - sub[row - 1][j + h] > 0 ? dp[o - 1][row - 1][j + h] % mod : 0L;
            }
        }
        for (int o = 1; o < number; o++) {
            for (int j = row - 2; j >= 0; j--) {
                for (int h = 1; h + j < row; h++)
                    dp[o][j][col - 1] += sub[j][col - 1] - sub[j + h][col - 1] > 0 ? dp[o - 1][j + h][col - 1] % mod : 0L;
            }
        }
        for (int o = 1; o < number; o++) {
            for (int i = row - 2; i >= 0; i--) {
                for (int j = col - 2; j >= 0; j--) {
                    for (int h = 1; h < row - i; h++) {
                        dp[o][i][j] += sub[i][j] - sub[i + h][j] > 0 ? dp[o - 1][i + h][j] % mod : 0L;
                    }
                    for (int h = 1; h < col - j; h++) {
                        dp[o][i][j] += sub[i][j] - sub[i][j + h] > 0 ? dp[o - 1][i][j + h] % mod : 0L;
                    }
                }
            }
        }
        return (int) (dp[number - 1][0][0] % mod);
    }

}
