package com.nyu.algorithm.basics;

public class GreatestCommonDivisor {

    public static int bruteForce(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i== 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    //(a,b)=d a和b的最大公约数为d
    // a % b = q .... r
    //(a,b)=(b,r) a和b的最大公约数 等于 b和r的最大公约数
    public static int euclidAlgorithm(int a, int b) {
        if (b == 0) {
            return a;
        }
        return euclidAlgorithm(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(euclidAlgorithm(3, 5));
    }
}
