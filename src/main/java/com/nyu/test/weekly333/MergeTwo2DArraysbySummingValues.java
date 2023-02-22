package com.nyu.test.weekly333;

import java.util.ArrayList;

public class MergeTwo2DArraysbySummingValues {
    // 时间复杂度 O(m+n)
    // 空间复杂度 O(1)
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 != nums1.length && index2 != nums2.length) {
            if (nums1[index1][0] < nums2[index2][0]) {
                list.add(new int[]{nums1[index1][0], nums1[index1][1]});
                index1++;
            } else if (nums1[index1][0] == nums2[index2][0]) {
                list.add(new int[]{nums1[index1][0], nums1[index1][1] + nums2[index2][1]});
                index1++;
                index2++;
            } else {
                list.add(new int[]{nums2[index2][0], nums2[index2][1]});
                index2++;
            }
        }
        while (index1 != nums1.length) {
            list.add(new int[]{nums1[index1][0], nums1[index1][1]});
            index1++;
        }
        while (index2 != nums2.length) {
            list.add(new int[]{nums2[index2][0], nums2[index2][1]});
            index2++;
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
