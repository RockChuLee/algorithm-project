package com.nyu.leetcode.weekly5;

import java.util.*;

public class LargestInteger {
    public static int largestInteger(int num) {
        char[] s = Integer.toString(num).toCharArray();
        List<Boolean> flag = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (char c : s) {
            Integer integer = Integer.valueOf(String.valueOf(c));
            if (integer % 2 == 0) {
                flag.add(true);
                even.add(integer);
            } else {
                flag.add(false);
                odd.add(integer);
            }
        }

        Collections.sort(odd,Collections.reverseOrder());
        Collections.sort(even,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();



        for (Boolean aBoolean : flag) {
            if (aBoolean) {
                sb.append(even.remove(0));
            } else {
                sb.append(odd.remove(0));
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
    }
}
