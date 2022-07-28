package com.nyu.test;

import com.nyu.util.std.StdOut;

class Solution {
    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static int count = 0;

    public static int movingCount(int m, int n, int k) {
        if(m == 0|| n ==0){
            return 0;
        }

        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i,j,m,n,k,visited);
            }
        }
        return count;
    }

    public static void dfs(int i, int j,int m, int n, int k, boolean[][] visited){
        if(sum(i)+sum(j)<=k&&!visited[i][j]){
            count++;
        }else{
            return;
        }
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if(newi >= 0 && newi < m && newj >= 0 && newj < n){
                dfs(newi,newj,m,n,k,visited);
            }
        }
    }

    public static int sum(int i){
        int sum = 0;
        while(i>10){
            sum+=i%10;
            i = i/10;
        }
        return sum+i;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }
}
