package com.nyu.test;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class DailyQuestion {
    public static long countSubarrays(Queue<Integer> queue,int index) {
        queue.poll();
        while (queue.size() != 0) {
            countSubarrays(queue, index++);
            countSubarrays(queue, index++);
            System.out.println(index);
        }
        return 0;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        countSubarrays(queue, 0);
    }
}
