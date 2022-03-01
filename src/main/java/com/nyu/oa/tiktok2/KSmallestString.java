package com.nyu.oa.tiktok2;

import java.util.ArrayList;
import java.util.List;

public class KSmallestString {
    public static int minSubArrayLen(String s, int k) {
        List<Integer> list = new ArrayList<>();
        int length = s.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if ('1' == s.charAt(i)) {
                list.add(i);
            }
        }
        if (list.isEmpty() || list.size() < k) {
            return 0;
        }
        for (int i = 0; i + k - 1 < list.size(); i++) {
            Integer begin = list.get(i);
            Integer end = list.get(i + k - 1) + 1;
            min = Math.min(min, Integer.parseInt(s.substring(begin, end)));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen("101010001", 2));
    }
}
