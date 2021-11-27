package com.nyu.leetcode;

public class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        int rowLength = this.matrix.length;
        int colLength = this.matrix[0].length;
        int[][] result = new int[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i != 0 && j != 0) {
                    result[i][j] = result[i - 1][j] + result[i][j - 1] + this.matrix[i][j] - result[i - 1][j - 1];
                } else if (i != 0) {
                    result[i][j] = result[i - 1][j] + this.matrix[i][j];
                } else if (j != 0) {
                    result[i][j] = result[i][j - 1] + this.matrix[i][j];
                } else {
                    result[i][j] = this.matrix[i][j];
                }
            }
        }

        if (col1 != 0 && row1 != 0) {
            return result[row2][col2] - result[row1 - 1][col2] - result[row2][col1 - 1] + result[row1 - 1][col1 - 1];
        } else if (col1 != 0) {
            return result[row2][col2] - result[row2][col1 - 1];
        }else if(row1 !=0){
            return result[row2][col2] - result[row1 - 1][col2];
        }else {
            return result[row2][col2];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
    }
}
