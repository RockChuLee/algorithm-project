package com.nyu.oa.expedia;

public class ArrayGenerator {
    public static int[] getSmallestArray(int[] arr,int r, int l) {
        int length = arr.length;
        if (length == 0) {
            return new int[]{};
        }
        int[] brr = new int[length];
        int[] diff = new int[length];
        brr[0] = Math.max(arr[0], r);
        diff[0] = 0;
        for (int i = 1; i < length; i++) {
            brr[i] = Math.max(brr[i - 1], arr[i] + diff[i - 1]);
            if (brr[i] > l) {
                return new int[]{-1};
            }
            diff[i] = brr[i] - arr[i];
        }
        return brr;
    }
}
