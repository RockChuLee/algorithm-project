package com.nyu.test.weekly4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumCandies {

    List<Integer> list;

    public int maximumCandies(int[] candies, long k) {

        if (k > Arrays.stream(candies).sum()) {
            return 0;
        }

        list = Arrays.stream(candies).boxed().sorted().collect(Collectors.toList());

        if (k <= list.size()) {
            return list.get((int) (list.size() - k));
        }

        while (k > list.size()) {
            Integer poll = list.remove(list.size() - 1);
            int e = poll / 2;
            offer(e);
            offer(poll - e);
        }

        return list.get(0);
    }

    public void offer(int e) {
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            if (list.get(i) <= e || i == 0) {
                list.add(i, e);
                break;
            }
        }
    }

    public static void main(String[] args) {
        MaximumCandies a = new MaximumCandies();
        System.out.println(a.maximumCandies(new int[]{5, 8, 6}, 4));
    }
}
