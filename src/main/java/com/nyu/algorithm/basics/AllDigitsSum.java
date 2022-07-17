package com.nyu.algorithm.basics;

public class AllDigitsSum {
    public static int calculate(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate(10));
    }
}
