package com.nyu.leetcode.weekly4;

import java.util.*;

public class FindWinners {
    public static List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> win = new HashSet<>();
        HashSet<Integer> oneTime = new HashSet<>();
        HashSet<Integer> fail = new HashSet<>();

        for (int[] match : matches) {
            int a = match[0];
            int b = match[1];
            if(!fail.contains(a)){
                win.add(a);
            }


            if (fail.contains(b)) {
                oneTime.remove(b);
            }else {
                oneTime.add(b);
            }
            fail.add(b);
            if(win.contains(b)){
                win.remove(b);
            }
        }

        List<Integer> answer1 = new ArrayList<>(win);
        List<Integer> answer2 = new ArrayList<>(oneTime);
        Collections.sort(answer1);
        Collections.sort(answer2);
        return Arrays.asList(answer1,answer2);
    }

    public static void main(String[] args) {
        findWinners(new int[][]{{1, 5}, {2, 5}, {2, 8}, {2, 9}, {3, 8}, {4, 7}, {4, 9}, {5, 7}, {6, 8}});
    }
}
