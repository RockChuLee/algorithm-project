package com.nyu.test;

import java.util.Arrays;

public class DailyQuestion {

    public static char[][] candyCrush(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int mins = Integer.MAX_VALUE;
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; i++) {
            int cur = 0;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                ans[j][i] = '.';
                if (matrix[j][i] == '.') cur++;
                else {
                    if (flag && matrix[j][i] == '#') {
                        mins = Math.min(mins, cur);
                    }
                    cur = 0;
                    flag = matrix[j][i] == 'F';
                }
            }
            if (flag) {
                mins = Math.min(mins, cur);
            }
        }
        System.out.println(mins);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '#') ans[i][j] = '#';
                else if (matrix[i][j] == 'F') ans[i + mins][j] = 'F';

            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(candyCrush(new char[][]
                {{'#', '#', '#'},
                        {'#', 'F', '#'},
                        {'#', '.', '#'},
                        {'#', '.', '#'},
                        {'#', '.', '#'}})));

//                System.out.println(Arrays.deepToString(candyCrush(new char[][]{
//                {'F'}})));

    }
}