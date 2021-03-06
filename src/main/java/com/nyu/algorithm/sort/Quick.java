package com.nyu.algorithm.sort;

import com.nyu.util.std.StdRandom;

/**
 * 时间复杂度：O(nlog(n))
 * 空间复杂度：O(log(n))
 */
public class Quick extends Example {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);        // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数值切分为a[lo..i-1],a[i].a[i+1..hi]
        int i = lo, j = hi + 1;                 // 左右扫描指针
        Comparable v = a[lo];                   // 切分元素
        while (true) {
            // 扫描左右， 检查扫描是否结束并交换元素
            while (less(a[i++], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // 将 v = a[j] 放入正确的位置
        return j; // 将a[lo..j-1]<=a[j].a[j+1..hi] 达成
    }
}
