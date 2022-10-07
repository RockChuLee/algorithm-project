package com.nyu.oa.expedia;

public class EvenTag {
    public static int way(int[] arr) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            res += i;
            if (i % 2 != 0 && i < min) {
                min = i;
            }
        }
        if (res % 2 != 0 && min != Integer.MAX_VALUE) {
            res -= min;
        }
        return res;
    }
}
