package com.nyu.test.archive.weekly9;

import java.util.*;
import java.util.stream.IntStream;

public class SmallestTrimmedNumbers {
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int m = nums[0].length();
        for (int p = 0; p < queries.length; p++) {
            int[] q = queries[p];
            ArrayList<Integer> idx = new ArrayList<>(Arrays.asList(IntStream.range(0, nums.length).boxed().toArray(Integer[]::new)));
            idx.sort(Comparator.comparing(i -> nums[i].substring(m - q[1]))); // 稳定排序
            ans[p] = idx.get(q[0] - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestTrimmedNumbers(new String[]{"24","37","96","04"}, new int[][]{{2, 1}, {2, 2}})));
    }
}
