package com.nyu.test;


public class DailyQuestion {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int left = 0;
        int down = m-1;
        int right = n-1;
        int row = -1;
        while(up<=down){
            int mid = up+(down-up)/2;
            if(matrix[mid][0]<target){
                up = mid+1;
            }else if(matrix[mid][0]>target){
                down = mid-1;
            }else if(matrix[mid][0]==target){
                return true;
            }
        }
        row = matrix[up][0]<target?up:up-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(matrix[row][mid]<target){
                left = mid+1;
            }else if(matrix[row][mid]>target){
                right = mid-1;
            }else if(matrix[row][mid]==target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3);
    }
}
