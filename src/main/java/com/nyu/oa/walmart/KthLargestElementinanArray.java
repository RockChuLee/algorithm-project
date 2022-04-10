package com.nyu.oa.walmart;

import java.util.PriorityQueue;

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

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int index, int heapSize) {
        int l = index * 2 + 1, r = index * 2 + 2, largest = index;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != index) {
            swap(nums, index, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest1(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public static void main(String[] args) {
        KthLargestElementinanArray kthLargestElementinanArray = new KthLargestElementinanArray();
        System.out.println(kthLargestElementinanArray.findKthLargest1(new int[]{1, 3, 4, 2, 9, 8, 6}, 2));
    }
}
