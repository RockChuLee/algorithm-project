package com.nyu.test.archive.weekly7;

import java.util.*;

public class CountLatticePoints {
    public int countLatticePoints(int[][] circles) {
        Set<Point> result = new HashSet<>();
        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    double pow = Math.sqrt(Math.pow(Math.abs(i - x),2) + Math.pow(Math.abs(j - y),2) );
                    if (pow <= r) {
                        result.add(new Point(i, j));
                    }
                }
            }
        }
        return result.size();
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) {
        CountLatticePoints countLatticePoints = new CountLatticePoints();
        System.out.println(countLatticePoints.countLatticePoints(new int[][]{{8, 9, 6}, {9, 8, 4}, {4, 1, 1}, {8, 5, 1}, {7, 1, 1}, {6, 7, 5}, {7, 1, 1}, {7, 1, 1}, {5, 5, 3}}));
    }
}
