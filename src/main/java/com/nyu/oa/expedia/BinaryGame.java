package com.nyu.oa.expedia;

import java.util.Arrays;

public class BinaryGame {
    public static void main(String[] args) {
        int min = 1, max = 3, one = 2, zero = 1;
        System.out.println(extracted(min, max, one, zero));

    }

    public static long extracted(int min, int max, int one, int zero) {
        long mod = 1000000007L;
        long[] dp = new long[max + 1];
        Arrays.fill(dp, 0);
        dp[one] = dp[one] + 1;
        dp[zero] = dp[zero] + 1;
        for (int i = min; i <= max; i++) {
            if (i - one >= 0) {
                dp[i] += dp[i - one] % mod;
            }
            if (i - zero >= 0) {
                dp[i] += dp[i - zero] % mod;
            }
        }
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += dp[i] % mod;
        }
        return sum;
    }
}
