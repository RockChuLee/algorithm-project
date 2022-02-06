package com.nyu.oa.facebook;

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] arr, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(arr, i, heapSize);
        }
    }

    public void maxHeapify(int[] arr, int index, int heapSize) {
        int l = index * 2 + 1, r = index * 2 + 2, largest = index;
        if (l < heapSize && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != index) {
            swap(arr, index, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
