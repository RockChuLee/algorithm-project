package com.nyu.oa.expedia;

import java.util.HashMap;
import java.util.List;

public class ComplementaryPairs {

    public static long countComplementary(List<String> lists, int size) {
        long ans = 0;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            String cur = lists.get(i);
            long temp = 0;
            for (int j = 0; j < cur.length(); j++) {
                temp ^= (1 << (int) cur.charAt(j));
            }
            ans += map.getOrDefault(temp, 0L);
        }
        return ans;
    }
}
