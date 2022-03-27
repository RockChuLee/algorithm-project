package com.nyu.leetcode.weekly3;

import java.util.ArrayList;
import java.util.List;

public class KkthPalindrome {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int scale = intLength + 1 / 2;
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int[] operator = new int[scale];
            for (int i1 = 0; i1 < operator.length; i1++) {
                int value = query % 10;
                if (i1 == 0) {
                    value = value - 1;
                }else {
                    value = value + 1;
                }
            }
        }
        return new long[]{};
    }
}
