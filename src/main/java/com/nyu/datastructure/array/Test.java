package com.nyu.datastructure.array;

public class Test {
    static int[] nums = new int[]{-2,4,-1,2};
    static int[] nums1 = new int[]{1,2,3,0,0,0};
    static int[] nums2 = new int[]{2,5,6};

    public static void main(String[] args) {
//        containsDuplicate();
//        maximumSubarray();
        merge();
    }

    private static void maximumSubarray() {
        System.out.println("MaximumSubarray : " + MaximumSubarray.maxSubArray(nums));
    }

    private static void containsDuplicate() {
        System.out.println("ContainsDuplicate : " + ContainsDuplicate.containsDuplicate(nums));
    }

    private static void merge() {
        MergeSortedArray.merge1(nums1,3,nums2,3);
    }
}
