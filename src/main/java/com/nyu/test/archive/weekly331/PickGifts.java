package com.nyu.test.archive.weekly331;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PickGifts {
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(gifts.length, Comparator.reverseOrder());
        for (int gift : gifts) {
            pq.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            pq.offer((int) Math.sqrt(pq.poll()));
        }

        return pq.stream().mapToLong(Integer::intValue).sum();

    }

    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{99},4));
    }
}
