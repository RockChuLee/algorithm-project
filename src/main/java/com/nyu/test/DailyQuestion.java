package com.nyu.test;

import java.util.Arrays;
import java.util.HashMap;

public class DailyQuestion {

    public static int partitionString(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            int temp = map.get(s.charAt(i));
            if (max < temp) {
                max = temp;
            }
        }
        int a = 0;
        return max;
    }

    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int ans = 0;
        int target = 0;
        int temp = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start > target) {
                target = end;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        minGroups(new int[][]{{1, 3}, {5, 6}, {8, 10}, {11, 13}});
    }
}