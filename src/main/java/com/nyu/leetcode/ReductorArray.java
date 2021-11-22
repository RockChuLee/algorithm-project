package com.nyu.leetcode;

import java.util.Arrays;
import java.util.List;

/*
假设a=[1,2,3], b=[4,5,6], d=2， 那么a[0]与b的所有差值是[3,4,5], a[1]是[2,3,4], a[2]是[1,2,3]，返回1，因为只有a[0]的所有差值都大于2
我是sort了a和b，然后然后从最小的a和b里的值开始计算，遇到一个差值小于d的就break
初始化result为长度，遍历，不符合的结果减一并且break，返回result
大意如下，给一个a数组和一个ｂ数组，还要一个整数ｄ，求ａ中的符合与任一ｂ中元素的差的绝对值都大于ｄ的元素的个数。
例子：ａ＝［３，４，５］，　ｂ　＝　［１２，８，１０］，　ｄ　＝　４。输出：１.　
只有ａ［０］＝３符合。｜３－１２｜　＝　９＞４，　｜３－８｜＝５＞４，｜３－１０｜＝７＞４．　对于ａ［１］＝４，｜４－８｜＝４不符合。对于ａ［２］＝５，｜５－８｜＝３＜４，不符合。
ａ和ｂ的ｓｉｚｅ可以到１０＾５.　
先把ｂ排序，然后对每个ａ的元素，在ｂ里做binary　search。
暴力就可以过, ComparatorValue： 给A，B两个int array和一个difference， 拿A里面的每个数和整个B array里的数做比较，A里面每有一个数和B里面某个数的绝对值差小于difference，comparator value++。 最后return comparator。 这道题用两个for loop，每对儿都比一遍就行，不难
 */
public class ReductorArray {

    public static int comparatorValue(int[] a, int[] b, int target) {
        int result = a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Math.abs(a[i] - b[j]) <= target) {
                    result--;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        System.out.println(comparatorValue(a, b, 2));
    }
}
