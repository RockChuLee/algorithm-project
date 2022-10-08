package com.nyu.oa.expedia;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumHealth {
    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>((o1, o2) -> o1.compareTo(o2));
        for (Integer x : initial_players) {
            if (minheap.size() == rank && x > minheap.peek()) {
                minheap.poll();
                minheap.offer(x);
            } else minheap.offer(x);
        }
        long ans = minheap.peek();
        for (int x : new_players) {
            if (minheap.size() == rank && x > minheap.peek()) {
                minheap.poll();
                minheap.offer(x);
            }
            ans += minheap.peek();
        }
        return ans;
    }
}
