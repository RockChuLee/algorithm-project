package com.nyu.oa.citadel;

public class StraightTrail {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1], val = update[2];
            res[start] += val;
            if (end < length - 1) res[end + 1] -= val;
        }
        int cur = 0;
        // "range caching"
        for (int i = 0; i < length; i ++) {
            cur += res[i];
            res[i] = cur;
        }
        return res;
    }
}
