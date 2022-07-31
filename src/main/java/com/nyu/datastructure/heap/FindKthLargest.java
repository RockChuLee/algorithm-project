package com.nyu.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.offer(n);
            if (heap.size() > k)
                heap.poll();
        }

//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            public int compare(Integer num1, Integer num2) {
//                return num2 - num1;
//            }
//        });

        // output
        return heap.poll();

    }
}
