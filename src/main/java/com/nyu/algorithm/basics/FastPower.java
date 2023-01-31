package com.nyu.algorithm.basics;

public class FastPower {

    // iterator
    // time complexity: O(logn)
    // space complexity: O(1)
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        double base = x;
        while (N > 0) {
            if (N % 2 == 1) {
                result = result * base;
            }
            base = base * base;
            N = N / 2;
        }
        return result;
    }

    // recursion
    // time complexity: O(logn)
    // space complexity: O(1)
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = n;
        double result = x;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        if (N % 2 == 1) {
            result = x * result;
        }
        x = x * x;
        result = myPow1(result, n / 2);
        return result;
    }

}
