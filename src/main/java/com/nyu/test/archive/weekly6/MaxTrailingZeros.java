package com.nyu.test.archive.weekly6;


public class MaxTrailingZeros {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxTrailingZeros(int[][] grid) {
        int h = grid.length, w = grid[0].length;
        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int[] dir : directions) {
                    int flag = check(grid, 0, i, j, dir, true);
                    max = Math.max(max, checkZero(flag));
                }
            }
        }

        return max;
    }

    private int checkZero(int flag) {
        int i = 0;
        while (flag % 10 == 0) {
            i++;
            flag = flag / 10;
        }
        return i;
    }

    public int check(int[][] grid, int result, int i, int j, int[] direction, boolean convert) {
        if (j < 0 || j > grid[0].length) {
            return result;
        }

        if (convert) {
            convert = false;
            for (int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                if (newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length) {
                    result *= grid[newi][newj];
                    check(grid, result, newi, newj, dir, convert);
                }
            }
        }else {
            int newi = i + direction[0], newj = j + direction[1];
            if (newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length) {
                result *= grid[newi][newj];
                check(grid, result, newi, newj, direction, convert);
            }
        }

        return result;
    }
}
