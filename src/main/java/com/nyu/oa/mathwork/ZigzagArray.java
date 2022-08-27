package com.nyu.oa.mathwork;

import java.util.Arrays;

public class ZigzagArray {

    public static void main(String[] args) {
        int[] arg = new int[]{-1, 1, 2, 3, -5};

        int[] ans = getInts(arg);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] getInts(int[] arg) {
        Arrays.sort(arg);

        int length = arg.length;
        int[] ans = new int[length];
        int left = 0;
        int right = length - 1;
        int index = 0;

        while (left < right) {
            ans[index++] = arg[left++];
            ans[index++] = arg[right--];
        }

        if (left == right) {
            ans[index] = arg[left];
        }
        return ans;
    }
}
