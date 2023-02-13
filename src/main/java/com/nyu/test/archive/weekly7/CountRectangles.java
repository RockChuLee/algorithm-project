package com.nyu.test.archive.weekly7;

import java.util.*;
import java.util.stream.IntStream;

public class CountRectangles {
    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        Arrays.sort(rectangles, (a, b) -> b[1] - a[1]);

        int n = points.length;
        Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, (i, j) -> points[j][1] - points[i][1]);

        int[] ans = new int[n];
        List<Integer> xs = new ArrayList<>();
        int i = 0;
        for (int id : ids) {
            int start = i;
            while (i < rectangles.length && points[id][1] <= rectangles[i][1])
                xs.add(rectangles[i++][0]);
            if (start < i) Collections.sort(xs); // 只有在 xs 插入了新元素时才排序
            ans[id] = i - lowerBound(xs, points[id][0]);
        }
        return ans;
    }

    public static int lowerBound(List<Integer> xs, int x) {
        int left = 0, right = xs.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (xs.get(mid) >= x)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countRectangles(new int[][]{{1, 2}, {2, 3}, {2, 5}}, new int[][]{{2, 1}, {1, 4}})));
    }
}
