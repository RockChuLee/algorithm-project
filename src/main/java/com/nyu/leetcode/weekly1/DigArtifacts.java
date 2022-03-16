package com.nyu.leetcode.weekly1;

import java.util.HashSet;

public class DigArtifacts {
    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] grid = new int[n][n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < artifacts.length; i++) {
            for (int j = artifacts[i][0]; j < artifacts[i][2] + 1; j++) {
                for (int k = artifacts[i][1]; k < artifacts[i][3] + 1; k++) {
                    grid[j][k] = i + 1;
                }
            }
        }
        for (int i = 0; i < dig.length; i++) {
            grid[dig[i][0]][dig[i][1]] = 0;
        }
        for (int i = 0; i < artifacts.length; i++) {
            for (int j = artifacts[i][0]; j < artifacts[i][2] + 1; j++) {
                for (int k = artifacts[i][1]; k < artifacts[i][3] + 1; k++) {
                    if (grid[j][k] != 0) {
                        set.add(grid[j][k]);
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] != 0) {
//                    set.add(grid[i][j]);
//                }
//            }
//        }
        return artifacts.length - set.size();
    }

    public static void main(String[] args) {
        digArtifacts(5, new int[][]{{3, 1, 4, 1}, {1, 1, 2, 2}, {1, 0, 2, 0}, {4, 3, 4, 4}, {0, 3, 1, 4}, {2, 3, 3, 4}}, new int[][]{{0, 0}, {2, 1}, {2, 0}, {2, 3}, {4, 3}, {2, 4}, {4, 1}, {0, 2}, {4, 0}, {3, 1}, {1, 2}, {1, 3}, {3, 2}});
    }
}
