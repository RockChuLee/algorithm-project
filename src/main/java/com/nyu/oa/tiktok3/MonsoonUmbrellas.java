package com.nyu.oa.tiktok3;

import java.util.Arrays;
import java.util.List;

public class MonsoonUmbrellas {

    public static int getUmbrellas(int requirement, List<Integer> sizes) {
        // Write your code here
        int max = requirement + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= requirement; i++) {
            for (int s : sizes) {
                if (s <= i) {
                    dp[i] = Math.min(dp[i], dp[i - s] + 1);
                }
            }
        }
        return dp[requirement] > requirement ? -1 : dp[requirement];
    }
}
