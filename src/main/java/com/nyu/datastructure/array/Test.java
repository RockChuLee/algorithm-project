package com.nyu.datastructure.array;

public class Test {
    static int[] nums = new int[]{-2,4,-1,2};

    public static void main(String[] args) {
//        containsDuplicate();
        maximumSubarray();
    }

    private static void maximumSubarray() {
        System.out.println("MaximumSubarray : " + MaximumSubarray.maxSubArray(nums));
    }

    private static void containsDuplicate() {
        System.out.println("ContainsDuplicate : " + ContainsDuplicate.containsDuplicate(nums));
    }
}
