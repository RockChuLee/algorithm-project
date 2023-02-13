package com.nyu.test.archive.weekly311;

public class SumofPrefixScoresofStrings {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? Math.max(n, 2) : n * 2;
    }
}
