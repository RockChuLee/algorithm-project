package com.nyu.oa.mathwork;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'canTraverseMaze' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER maxTime
     */

    public static String canTraverseMaze(List<String> grid, int maxTime) {
        int n = grid.size();
        int m = grid.get(0).length();
        Character[][] maze = new Character[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = grid.get(i).charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        return dfs(maze, visited, 0, 0, 0, maxTime);
    }

    public static String dfs(Character[][] maze, boolean[][] visited, int i, int j, int distance, int max) {

        // if(distance>max){
        //     return "No";
        // }
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            if (maze[i][j] == '.') {
                return "Yes";

            } else {
                return "No";
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && !visited[x][y]) {
                // visited[x][y] = true;
                if (maze[x][y] == '.') {
                    distance++;
                    if (dfs(maze, visited, x, y, distance, max).equals("Yes")) {
                        return "Yes";
                    }
                }

            }
        }
        // visited[i][j] = false;
        return "No";
    }


}

public class Maze2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gridCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, gridCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int maxTime = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.canTraverseMaze(grid, maxTime);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
