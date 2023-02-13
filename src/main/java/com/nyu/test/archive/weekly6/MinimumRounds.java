package com.nyu.test.archive.weekly6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumRounds {
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int amount = entry.getValue();
            if (amount == 1) {
                return -1;
            } else if (amount == 2 || amount == 3) {
                result++;
                continue;
            }
            int[] dp = new int[amount];
            Arrays.fill(dp, amount + 1);
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = Math.min(dp[i - 2], dp[i - 3]) + 1;
            }
            result += dp[amount - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{7,7,7,7,7,7,7}));
    }
}
