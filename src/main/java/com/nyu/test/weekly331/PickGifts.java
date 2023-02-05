package com.nyu.test.weekly331;

import java.util.Arrays;

public class PickGifts {
    public static long pickGifts(int[] gifts, int k) {
        if (gifts.length == 0) {
            return 0;
        }
        while (k > 0) {
            Arrays.sort(gifts);
            int length = gifts.length;
            int max = gifts[length - 1];
            gifts[length - 1] = (int) Math.sqrt(max);
            k--;
        }
        int sum = 0;
        for (int n : gifts) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{99},4));
    }
}
