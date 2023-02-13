package com.nyu.test.archive.weekly3;

public class KkthPalindrome {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int lenQ = queries.length;
        long[] res = new long[lenQ];
        int base = (int) Math.pow(10, (intLength - 1) / 2);
        for (int i = 0; i < lenQ; i++) {
            int curQuery = queries[i];
            if (curQuery > 9 * base) {
                res[i] = -1;
                continue;
            }
            long x = base + curQuery - 1;
            long y = x;
            if (intLength % 2 == 1)
                y = y / 10;

            for (; y > 0; y /= 10) {
                x = x * 10 + y % 10;
            }
            res[i] = x;
        }

        return res;
    }
}
