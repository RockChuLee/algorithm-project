package com.nyu.algorithm.basics;

public class FastPower {

    // iterator
    // time complexity: O(logn)
    // space complexity: O(1)
    public double myPow(double x, int n) {
        // if n = -2147483648, the -n will be out of bound.
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
    // space complexity: O(logn)
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

}
