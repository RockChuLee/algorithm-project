package com.nyu.leetcode;

//https://leetcode-cn.com/problems/path-with-maximum-gold/submissions/
public class PathwithMaximumGold {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] grid;
    int m, n;
    int ans = 0;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return ans;
    }

    public void dfs(int x, int y, int gold) {
        gold += grid[x][y];
        ans = Math.max(ans, gold);

        int rec = grid[x][y];
        grid[x][y] = 0;

        for (int d = 0; d < 4; ++d) {
            int nx = x + dirs[d][0];
            int ny = y + dirs[d][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                dfs(nx, ny, gold);
            }
        }
        grid[x][y] = rec;
    }

    public static void main(String[] args) {
        PathwithMaximumGold pathwithMaximumGold = new PathwithMaximumGold();
        int[][] dirs = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        pathwithMaximumGold.getMaximumGold(dirs);
    }
}
