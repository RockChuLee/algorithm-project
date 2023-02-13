package com.nyu.test.weekly332;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubstringXORQueries {
    private static final int[] NOT_FOUND = new int[]{-1, -1};

    public static int[][] substringXorQueries(String S, int[][] queries) {
        Map<Integer, int[]> m = new HashMap<>();
        int i = S.indexOf('0');
        if (i >= 0) m.put(0, new int[]{i, i}); // 这样下面就可以直接跳过 '0' 了，效率更高
        char[] s = S.toCharArray();
        for (int l = 0, n = s.length; l < n; ++l) {
            if (s[l] == '0') continue;
            for (int r = l, x = 0; r < Math.min(l + 30, n); ++r) {
                // 将 二进制码 转换成 十进制
                x = x << 1 | (s[r] & 1);
                if (!m.containsKey(x) || r - l < m.get(x)[1] - m.get(x)[0])
                    m.put(x, new int[]{l, r});
            }
        }

        int[][] ans = new int[queries.length][];
        for (i = 0; i < queries.length; i++)
            ans[i] = m.getOrDefault(queries[i][0] ^ queries[i][1], NOT_FOUND);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(substringXorQueries("101101", new int[][]{{0, 5}, {1, 2}})));
    }
}

