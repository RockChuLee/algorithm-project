package com.nyu.test.weekly334;

import java.util.*;

public class MinimumTimetoVisitaCellInaGrid {
    private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // dijkstra
    //时间复杂度：O(mnlogmn)，其中 m 和 n 分别为 grid 的行数和列数。
    //空间复杂度：O(mn)
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) // 无法「等待」
            return -1;

        int[][] dis = new int[m][n];
        for (int i = 0; i < m; ++i)
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});
        for (; ; ) {
            int[] p = pq.poll();
            int d = p[0], i = p[1], j = p[2];
            if (i == m - 1 && j == n - 1)
                return d;
            for (int[] q : dirs) { // 枚举周围四个格子
                int x = i + q[0], y = j + q[1];
                if (0 <= x && x < m && 0 <= y && y < n) {
                    int nd = Math.max(d + 1, grid[x][y]);
                    nd += (nd - x - y) % 2; // nd 必须和 x+y 同奇偶
                    if (nd < dis[x][y]) {
                        dis[x][y] = nd; // 更新最短路
                        pq.add(new int[]{nd, x, y});
                    }
                }
            }
        }
    }

    private int[][] grid, vis;

    // bfs + 二分
    //时间复杂度：O(mnlogU)，其中 m 和 n 分别为 grid 的行数和列数，U 为 grid[i][j] 的最大值。
    //空间复杂度：O(mn)。
    public int minimumTime2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) // 无法「等待」
            return -1;

        this.grid = grid;
        vis = new int[m][n];
        int left = Math.max(grid[m - 1][n - 1], m + n - 2) - 1;
        int right = (int) 1e5 + m + n; // 开区间
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid)) right = mid;
            else left = mid;
        }
        return right + (right + m + n) % 2;
    }

    private boolean check(int endTime) {
        int m = grid.length, n = grid[0].length;
        vis[m - 1][n - 1] = endTime;
        List<int[]> q = new ArrayList<>();
        q.add(new int[]{m - 1, n - 1});
        for (int t = endTime - 1; !q.isEmpty(); --t) {
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] p : tmp) {
                int i = p[0], j = p[1];
                for (int[] d : dirs) { // 枚举周围四个格子
                    int x = i + d[0], y = j + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && vis[x][y] != endTime && grid[x][y] <= t) {
                        if (x == 0 && y == 0) return true;
                        vis[x][y] = endTime; // 用二分的值来标记，避免重复创建 vis 数组
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }


}
