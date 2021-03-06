package com.nyu.oa.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/merge-intervals/
public class MergeIntervals {
    //Time Complexity: nlogn
    //Time Complexity:
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
//        int[][] result = new int[][]{{1, 4}, {4, 5}};
//        int[][] result = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        System.out.println(Arrays.deepToString(merge(result)));
    }
}
