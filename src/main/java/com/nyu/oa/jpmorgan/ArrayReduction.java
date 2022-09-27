package com.nyu.oa.jpmorgan;

public class ArrayReduction {
    static int convert(int m, int n) {
        if (m == n)
            return 0;

        // only way is to do
        // -1 (m - n) times
        if (m > n)
            return m - n;

        // not possible
        if (m <= 0 && n > 0)
            return -1;

        // n is greater and n is odd
        if (n % 2 == 1)

            // perform '-1' on m
            // (or +1 on n)
            return 1 + convert(m, n + 1);

            // n is even
        else
            // perform '*2' on m
            // (or n / 2 on n)
            return 1 + convert(m, n / 2);
    }

    public static void main(String[] args) {
        int m = 15, n = 32;
        System.out.println("Minimum number of " +
                "operations : " +
                convert(m, n));
    }
}
