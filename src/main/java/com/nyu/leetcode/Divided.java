package com.nyu.leetcode;

public class Divided {
    public static int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }

        boolean flag = false;
        if (divisor > 0 && dividend > 0) {
            flag = true;
        } else if (divisor < 0 && dividend < 0) {
            flag = true;
        }

        int result = 0;
        int sum = 0;

        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);

        while (true) {

            sum += divisor;
            if (sum > dividend) {
                break;
            }
            if (sum == dividend) {
                result++;
                break;
            }
            result++;
        }
        if (flag) {
            return result;

        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(0, 1));
    }
}
