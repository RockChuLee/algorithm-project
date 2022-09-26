package com.nyu.test.weekly311;

import java.util.Arrays;

public class LengthoftheLongestAlphabeticalContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        int length = s.length();
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < length; i++) {
            if ((int) s.charAt(i) - (int) s.charAt(i - 1) == 1) {
                dp[i] = dp[i-1]+1;
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

}
