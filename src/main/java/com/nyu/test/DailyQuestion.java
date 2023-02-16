package com.nyu.test;

import java.util.Collections;

class DailyQuestion {
    private static int extracted() {
        int n = 1;
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    public  static int reverseBits(int n) {
        int res = 1;
        while(n!=0){
            res |=  n & 1 ;
            n  = n >> 1;
            res = res<< 1;
        }
        return res >> 1;
    }

    public static void main(String[] args) {

    }
}

