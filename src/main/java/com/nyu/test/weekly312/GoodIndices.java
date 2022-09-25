package com.nyu.test.weekly312;

import java.util.ArrayList;
import java.util.List;

public class GoodIndices {
    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        List<int[]> positive = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int start = i;
            while (i < length-1 && nums[i] <= nums[i + 1]) {
                i++;
            }
            if (i != start) {
                positive.add(new int[]{start, i});
            }
        }
        List<int[]> negative = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int start = i;
            while (i < length-1 &&nums[i] >= nums[i + 1]) {
                i++;
            }
            if (i != start) {
                negative.add(new int[]{start, i});
            }
        }
        for (int i = k; i < length - k; i++) {
            boolean pre = k == 1;
            boolean suf = k == 1;
            for (int[] ints : negative) {
                if (ints[0] <= i - k && ints[1] >= i-1) {
                    pre = true;
                    break;
                }
            }

            for (int[] ints : positive) {
                if (ints[0] <= i+1 && ints[1] >= i + k) {
                    suf = true;
                    break;
                }
            }
            if (suf && pre) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(goodIndices(new int[]{478184,863008,716977,921182,182844,350527,541165,881224}, 1));
    }
}
