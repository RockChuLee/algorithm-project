package com.nyu.oa.twitter;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/363036/Twitter-or-OA-2019-or-Activate-Fountain
//https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class ActivateFountain {
    public int minTaps(int n, int[] ranges) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        int[] dp = new int[n + 2];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int mn = i - ranges[i];
            int mx = i + ranges[i];
            for (int j = Math.max(mn, 0); j < Math.min(ranges.length, mx); j++) {
                dp[j] = Math.max(dp[j], mx);
            }
        }
        int curr = 0;
        int res = 0;
        while (curr < ranges.length) {
            if (curr == ranges.length - 1) return res;
            if (dp[curr] == 0) return -1;
            curr = dp[curr];
            res++;
        }
        if (curr < ranges.length) return -1;
        return res;
    }
}
