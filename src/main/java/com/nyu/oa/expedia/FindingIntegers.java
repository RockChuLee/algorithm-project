package com.nyu.oa.expedia;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/solution/
public class FindingIntegers {

    private static int k;
    private PriorityQueue<Integer> heap;

    public FindingIntegers(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int num: nums) {
            heap.offer(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
