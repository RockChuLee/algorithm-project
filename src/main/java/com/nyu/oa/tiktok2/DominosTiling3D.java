package com.nyu.oa.tiktok2;

// https://www.1point3acres.com/bbs/thread-835608-1-1.html
public class DominosTiling3D {


    private static int mod = 1000000007;

    public static int numTilings(int n) {
        long[] dp = new long[n + 2];
        long[] dpa = new long[n + 2];
        dp[0] = 1;
        dp[1] = 2;
        dpa[0] = 0;
        dpa[1] = 1;
        for (int i = 2; i <= n; i++) {
            dpa[i] = dpa[i - 1] + dp[i - 1] % mod;
            dp[i] = (2 * dpa[i] + 2 * dpa[i - 1] + dp[i - 2]) % mod;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTilings(3));
    }

}
