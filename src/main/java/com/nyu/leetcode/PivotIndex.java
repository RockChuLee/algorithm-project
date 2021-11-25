package com.nyu.leetcode;

import sun.text.resources.cldr.ii.FormatData_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {

        int length = nums.length;
        List<Long> left = new ArrayList<Long>();
        List<Long> right = new ArrayList<Long>(Collections.nCopies(length, 0L));
        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            left.add(sum);
        }
        sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum += nums[i];
            right.set(i, sum);
        }
        if (right.get(1) == 0) {
            return 0;
        }
        for (int k = 0; k < length - 2; k++) {
            if(k == 9237){
                System.out.println(left.get(k));
                System.out.println(right.get(k + 2));
            }
            if (left.get(k).equals(right.get(k + 2))) {
                return k + 1;
            }
        }
        if (left.get(length - 2) == 0) {
            return length - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,-1,-1,-1,-1,1};
        int[] nums = new int[]{-3,-6,9,0,2,0,-2,-4,6,-3,-6,9,0,2,0,-2,-4,6,-3,-6,9,0,2,0,-2,-4,6};
//        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
//        int[] nums = new int[]{2,1,-1};
        System.out.println(pivotIndex(nums));
    }
}
