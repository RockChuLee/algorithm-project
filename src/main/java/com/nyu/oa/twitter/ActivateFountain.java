package com.nyu.oa.twitter;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/363036/Twitter-or-OA-2019-or-Activate-Fountain
//https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class ActivateFountain {
    public static int fountainActivation(List<Integer> a) {
        // Write your code here
        int n = a.size();

        int interval[] = new int[n];

        for (int i = 1; i <= n; i++) {
            int left = Math.max(i - a.get(i - 1), 1);
            int right = Math.min(i + a.get(i - 1), n);
            interval[left - 1] = Math.max(interval[left - 1], right);
        }

        int right = interval[0];
        int nextGreaterRight = right;
        int fountainsActivate = 1;

        for (int i = 1; i < n; i++) {
            nextGreaterRight = Math.max(nextGreaterRight, interval[i]);
            if (i == right) {
                fountainsActivate++;
                right = nextGreaterRight;
            }
        }

        return fountainsActivate;
    }
}
