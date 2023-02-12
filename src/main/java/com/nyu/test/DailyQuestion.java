package com.nyu.test;

import java.util.Arrays;

class DailyQuestion {
    public static void main(String[] args) {

    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        int[][] ans = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i][0] ^ queries[i][1];
            String t = Integer.toBinaryString(target);
            if (s.contains(t)) {
                int index = s.indexOf(t);
                ans[i] = new int[]{index, index+ t.length()};
            }else{
                ans[i] = new int[]{-1, -1};
            }
        }
        return ans;
    }
}
