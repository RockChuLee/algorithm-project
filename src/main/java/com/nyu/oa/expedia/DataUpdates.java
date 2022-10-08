package com.nyu.oa.expedia;

public class DataUpdates {
    public static int[] data(int n, int[] data, int k, int[][] updates) {
        int length = data.length;
        int[] change = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            for (int i = start; i <= end; i++) {
                change[i]++;
            }
        }
        for (int i = 0; i <length ; i++) {
            if (change[i] % 2 != 0) {
                data[i] = -data[i];
            }
        }
        return data;
    }

}
