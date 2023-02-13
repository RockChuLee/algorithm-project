package com.nyu.test.archive.weekly9;

public class MinOperations {
    public static int minOperations(int[] nums, int[] numsDivide) {
        int g = 0;
        for (int x : numsDivide) g = gcd(g, x);
        int min = Integer.MAX_VALUE;
        for (int num : nums) if (g % num == 0) min = Math.min(min, num);
        if (min == Integer.MAX_VALUE) return -1;
        int ans = 0;
        for (int x : nums) if (x < min) ++ans;
        return ans;
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }


    public static void main(String[] args) {
        minOperations(new int[]{1, 2}, new int[]{1, 2, 3, 3});
    }
}
