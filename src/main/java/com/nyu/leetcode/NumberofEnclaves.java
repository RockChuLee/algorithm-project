package com.nyu.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode-cn.com/problems/number-of-enclaves/
public class NumberofEnclaves {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    // dfs
    //时间复杂度：O(mn)，其中 m 和 n 分别是网格 grid 的行数和列数。深度优先搜索最多访问每个单元格一次，需要 O(mn) 的时间，遍历网格统计飞地的数量也需要 O(mn) 的时间。
    //空间复杂度：O(mn)，其中 m 和 n 分别是网格 grid 的行数和列数。空间复杂度主要取决于 visited 数组和递归调用栈空间，空间复杂度是 O(mn)。

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }

    // bfs
    //时间复杂度：O(mn)，其中 m 和 n 分别是网格 grid 的行数和列数。广度优先搜索最多访问每个单元格一次，需要 O(mn) 的时间，遍历网格统计飞地的数量也需要 O(mn) 的时间。
    //空间复杂度：O(mn)，其中 m 和 n 分别是网格 grid 的行数和列数。空间复杂度主要取决于 visited 数组和队列空间，空间复杂度是 O(mn)。

    public int numEnclaves1(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        Queue<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                visited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                visited[i][n - 1] = true;
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (grid[0][j] == 1) {
                visited[0][j] = true;
                queue.offer(new int[]{0, j});
            }
            if (grid[m - 1][j] == 1) {
                visited[m - 1][j] = true;
                queue.offer(new int[]{m - 1, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0], currCol = cell[1];
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    // union find
    // 时间复杂度：O(mn \times \alpha(mn))O(mn×α(mn))，其中 mm 和 nn 分别是网格 \textit{grid}grid 的行数和列数，\alphaα 是反阿克曼函数。这里的并查集使用了路径压缩和按秩合并，单次操作的时间复杂度是 O(\alpha(mn))O(α(mn))，因此整个网格的并查集操作的时间复杂度是 O(mn \times \alpha(mn))O(mn×α(mn))，并查集操作之后需要 O(mn \times \alpha(mn))O(mn×α(mn)) 的时间再次遍历网格统计飞地的数量，因此总时间复杂度是 O(mn \times \alpha(mn))O(mn×α(mn))。
    // 空间复杂度：O(mn)O(mn)，其中 mm 和 nn 分别是网格 \textit{grid}grid 的行数和列数。并查集需要 O(mn)O(mn) 的空间。

    public int numEnclaves2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        uf.union(index, index + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        uf.union(index, index + n);
                    }
                }
            }
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !uf.isOnEdge(i * n + j)) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        NumberofEnclaves numberofEnclaves = new NumberofEnclaves();
        System.out.println(numberofEnclaves.numEnclaves2(grid));

        Queue<Integer> queue = new ArrayDeque<Integer>();
    }
}

class UnionFind {
    private int[] parent;
    private boolean[] onEdge;
    private int[] rank;

    public UnionFind(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        onEdge = new boolean[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    parent[index] = index;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        onEdge[index] = true;
                    }
                }
            }
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
                onEdge[rootx] |= onEdge[rooty];
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
                onEdge[rooty] |= onEdge[rootx];
            } else {
                parent[rooty] = rootx;
                onEdge[rootx] |= onEdge[rooty];
                rank[rootx]++;
            }
        }
    }

    public boolean isOnEdge(int i) {
        return onEdge[find(i)];
    }


}
