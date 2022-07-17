package com.nyu.algorithm.basics;

public class Fibonacci {

    //Time Complexity: O(N)
    //Auxiliary Space: O(1)
    public static void iterator(int N) {
        int num1 = 0, num2 = 1;

        int counter = 0;

        // Iterate till counter is N
        while (counter < N) {
            // Print the number
            System.out.print(num1 + " ");

            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
    }

    //Time Complexity: O(2^N)
    //Auxiliary Space: O(1)
    public static int recursion(int n) {
        // Base Case
        if (n <= 1)
            return n;

        // Recursive call
        return recursion(n - 1)
                + recursion(n - 2);
    }

    //Time Complexity: O(N)
    //Auxiliary Space: O(N)
    public static int dynamicProgramming(int n) {

        // Declare an array to store
        // Fibonacci numbers.
        // 1 extra to handle case, n = 0
        int f[] = new int[n + 2];

        int i;

        // 0th and 1st number of
        // the series are 0 and 1
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {

            // Add the previous 2 numbers
            // in the series and store it
            f[i] = f[i - 1] + f[i - 2];
        }

        // Nth Fibonacci Number
        return f[n];
    }

    public static void main(String args[]) {
        int N = 10;
        iterator(N);
        recursion(N);
        dynamicProgramming(N);
    }
}
