package com.nyu.datastructure.list_array.util;

import com.nyu.datastructure.list_array.ContainsDuplicate;
import com.nyu.datastructure.list_array.MaximumSubarray;
import com.nyu.datastructure.list_array.MergeSortedArray;

public class Test {
    static int[] nums = new int[]{-2,4,-1,2};
    static int[] nums1 = new int[]{1,2,3,0,0,0};
    static int[] nums2 = new int[]{2,5,6};

    public static void main(String[] args) {
//        containsDuplicate();
//        maximumSubarray();
//        merge();
        MyArray myArray = new MyArray();
        myArray.ListInsert(myArray, 1, 1);
        myArray.ListInsert(myArray, 1, 2);
        myArray.ListInsert(myArray, 1, 3);
        myArray.ListInsert(myArray, 1, 4);
        myArray.ListInsert(myArray, 1, 5);
        myArray.GetElem(myArray, 1, 0);
        System.out.println(myArray.returnValue);
        myArray.ListDelete(myArray, 3, 0);
        System.out.println(myArray.returnValue);
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
