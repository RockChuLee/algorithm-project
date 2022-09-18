package com.nyu.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>(Comparator.comparingInt(n -> n));

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.offer(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();

    }
}
