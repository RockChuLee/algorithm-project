package com.nyu.test.archive.weekly2;

import java.util.TreeMap;

public class LongestRepeating {
    TreeMap<Integer, Integer> map = new TreeMap<>((t0, t1) -> t1 - t0);
    TreeMap<Integer, Integer> treemap = new TreeMap<>();// 左->右

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int k = queryIndices.length;
        int[] ans = new int[k];
        for (int i = 0; i < n; ) {
            int r = i + 1;
            while (r < n && arr[r] == arr[i]) {
                r++;
            }
            treemap.put(i, r - 1);
            map.put(r - i, map.getOrDefault(r - i, 0) + 1);
            i = r;
        }
        for (int i = 0; i < k; i++) {
            int ptr = queryIndices[i];
            char changed = queryCharacters.charAt(i);
            int l = treemap.floorKey(ptr), r = treemap.get(l);
            if (changed != arr[ptr]) {
                if (ptr >= 1 && arr[ptr] == arr[ptr - 1] || ptr < n - 1 && arr[ptr] == arr[ptr + 1]) {
                    int l2 = treemap.floorKey(ptr), r2 = treemap.get(l2);
                    del(l2, r2, ptr);
                }
                boolean flag = false;
                if (ptr >= 1 && changed == arr[ptr - 1]) {
                    int r2 = ptr;
                    union(treemap.floorKey(ptr - 1), ptr - 1, ptr, r2);
                    flag = true;
                }
                if (ptr < n - 1 && changed == arr[ptr + 1]) {
                    int l2 = ptr;
                    if (flag) l2 = treemap.floorKey(ptr);
                    union(l2, ptr, ptr + 1, treemap.get(ptr + 1));
                }
            }
            // System.out.println(treemap);
            arr[ptr] = changed;
            ans[i] = map.firstEntry().getKey();
        }
        return ans;
    }

    // 将两个区间合并
    public void union(int l1, int r1, int l2, int r2) {
        // l2 = r1 + 1
        int len = r2 - l1 + 1, len1 = r1 - l1 + 1, len2 = r2 - l2 + 1;
        map.put(len1, map.getOrDefault(len1, 0) - 1);
        if (map.get(len1) == 0) map.remove(len1);
        map.put(len2, map.getOrDefault(len2, 0) - 1);
        if (map.get(len2) == 0) map.remove(len2);
        map.put(len, map.getOrDefault(len, 0) + 1);
        treemap.put(l1, r2);
        treemap.remove(l2);
    }

    // 将区间拆分
    public void del(int l, int r, int ptr) {
        // l2 = r1 + 1
        int len = r - l + 1, len1 = ptr - l, len2 = r - ptr;
        map.put(len, map.getOrDefault(len, 0) - 1);
        map.put(1, map.getOrDefault(1, 0) + 1);
        map.put(len1, map.getOrDefault(len1, 0) + 1);
        map.put(len2, map.getOrDefault(len2, 0) + 1);
        if (map.get(len) == 0) map.remove(len);
        if (l == ptr) {
            treemap.put(l, l);
            treemap.put(l + 1, r);
        } else if (r == ptr) {
            treemap.put(r, r);
            treemap.put(l, r - 1);
        } else {
            treemap.put(ptr, ptr);
            treemap.put(l, ptr - 1);
            treemap.put(ptr + 1, r);
        }
    }

}
