package com.nyu.leetcode;

public class NumMatrix {

    int[][] result;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            result = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //增加一列解决初始化问题
                    result[i][j + 1] = result[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += result[i][col2 + 1] - result[i][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
    }
}
