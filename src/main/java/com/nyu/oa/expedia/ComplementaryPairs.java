package com.nyu.oa.expedia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ComplementaryPairs {

    public static long countComplementary(List<String> lists, int size) {
        long ans = 0;
        HashMap<Long, Long> map = new HashMap<>();
        for (String cur : lists) {
            long temp = 0;
            for (int j = 0; j < cur.length(); j++) {
                temp ^= (1L << (int) cur.charAt(j) - 'a');
            }
            Long aLong = map.getOrDefault(temp, 0L);
            ans += aLong;
            for (int j = 0; j < 26; j++) {
                long bitmask = temp ^ (1L << j);;
                aLong = map.getOrDefault(bitmask, 0L);
                ans += aLong;
            }
            map.put(temp, aLong + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countComplementary(Arrays.asList("abc", "abcd", "bc", "adc"), 4));
//        String cur = "bc";
//        long temp = 0;
//        for (int j = 0; j < cur.length(); j++) {
//            temp ^= (1L << (int) cur.charAt(j) - 'a');
//        }
//        System.out.println(temp);
    }
}
