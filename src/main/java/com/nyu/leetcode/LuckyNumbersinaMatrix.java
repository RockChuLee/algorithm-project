package com.nyu.leetcode;

import java.util.*;

public class LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        if (matrix == null) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    map.put(i, j);
                }
            }

        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            boolean flag = true;
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int max = matrix[key][value];
            for (int i = 0; i < m; i++) {
                if (max < matrix[i][value] && i != key) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(max);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LuckyNumbersinaMatrix l = new LuckyNumbersinaMatrix();
//        System.out.println(l.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        System.out.println(l.luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}));
    }
}
