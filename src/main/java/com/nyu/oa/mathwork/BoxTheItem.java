package com.nyu.oa.mathwork;


public class BoxTheItem {

    public static int change(int amount, int coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins; i++) {
            for (int j = i; j <= amount; j++) {
                dp[j] += dp[j - i];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(7, 2));
    }

}
