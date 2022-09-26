package com.nyu.test.weekly312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodIndices {
    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] dec = new int[n];
        Arrays.fill(dec, 1);
        for (int i = n - 2; i >= 1; i--) {
            if (nums[i] <= nums[i + 1])
                dec[i] = dec[i + 1] + 1;
        }
        int inc = 1;
        for (int i = 1; i < n - 1; i++) {
            if (inc >= k && dec[i + 1] >= k)
                res.add(i);
            if (nums[i - 1] >= nums[i])
                inc++;
            else
                inc = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(goodIndices(new int[]{478184,863008,716977,921182,182844,350527,541165,881224}, 1));
    }
}
