package com.nyu.test.archive.weekly2;

import java.util.Arrays;

public class MaximumBobPoints {
//    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
//        int n = 12;
//        int maxScore = 0;
//        int[] res = new int[n];
//
//        for (int i = 0; i < 1 << n; i++) { // 即i < 2^12
//            // 用i来表示每一次结果，i是一个12位的二进制串，如100000000011表示第0、1、11个区域获胜，其他区域都失败
//            int score = 0;
//            int usedArrows = 0;
//            int[] bobArrows = new int[n];
//            for (int j = 0; j < 12; j++) {
//                if ((i >> j & 1) == 1) { // 若i右移j位后再与1的结果为1，即若i的第j位为1
//                    score += j; // 得分
//                    usedArrows += aliceArrows[j] + 1; // 使用箭(保证获胜即可，只多射一支箭)
//                    bobArrows[j] = aliceArrows[j] + 1; // 记录箭使用的区域和数量
//                }
//            }
//            if (usedArrows > numArrows) { // 若已使用的箭超出了箭的总量
//                continue;
//            }
//
//            if (score > maxScore) {
//                maxScore = score;
//                bobArrows[0] += (numArrows - usedArrows); // 没用完的箭随意放在第一个区域
//                res = bobArrows; // 数组复制
//            }
//        }
//        return res;

    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[][] dp = new int[12][numArrows + 1];
        for (int i = 1; i <= 11; i++) {
            for (int j = 0; j <= numArrows; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= aliceArrows[i] + 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - aliceArrows[i] - 1] + i);
                }
            }
        }
        int[] ans = new int[12];
        //再递归求出一种可行的方案
        dfs(aliceArrows, ans, dp, 11, numArrows);
        return ans;
    }

    public static void dfs(int[] aliceArrows, int[] ans, int[][] dp, int i, int j) {
        if (i == 0) return;
        for (int a = j; a >= 0; a--) {
            if (a == 0 || dp[i - 1][j - a] + i == dp[i][j] && a > aliceArrows[i]) {
                ans[i] = a;
                dfs(aliceArrows, ans, dp, i - 1, j - a);
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0})));
    }
}
