package com.nyu.oa.citadel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Triplets {


    static class Fenwik {
        long[] f;

        Fenwik(int n) {
            f = new long[n];
        }

        void add(int i, long v) {
            while (i < f.length) {
                f[i] += v;
                i = (i | (i + 1));
            }
        }

        long get(int i) {
            long ret = 0;
            while (i >= 0) {
                ret += f[i];
                i = (i & (i + 1)) - 1;
            }
            return ret;
        }
    }

    public static long solve(List<Long> d) {
        // Write your code here
        int n = d.size();
        long[] a = new long[n];
        for (int i = 0; i < n; ++i) {
            a[i] = d.get(i);
        }
        long[] b = a.clone();
        Arrays.sort(b);
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        for (long i : b) {
            if (!map.containsKey(i)) map.put(i, map.size());
        }
        Fenwik c1 = new Fenwik(map.size());
        Fenwik c2 = new Fenwik(map.size());
        long[] last1 = new long[map.size()];
        long[] last2 = new long[map.size()];
        Arrays.fill(last1, -1);
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = map.get(a[i]);
            if (last1[x] == -1) {
                c1.add(x, 1);
                c2.add(x, last1[x] = c1.get(x - 1));
                ans += last2[x] = c2.get(x - 1);
            } else {
                c2.add(x, c1.get(x - 1) - last1[x]);
                ans += c2.get(x - 1) - last2[x];
            }
        }
        return ans;

    }

}
