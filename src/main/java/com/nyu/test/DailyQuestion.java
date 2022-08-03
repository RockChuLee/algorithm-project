package com.nyu.test;

class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(2.0,-2147483648));
    }

    public static double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            n = -n;
        }
        if(n==0){
            return 1;
        }
        // System.out.println(n);
        double ans = myPow(x,n/2);
        return n%2==0?ans*ans:ans*ans*x;
    }
}
