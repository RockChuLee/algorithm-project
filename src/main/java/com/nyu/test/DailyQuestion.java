package com.nyu.test;

import java.util.*;

public class DailyQuestion {

    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank){
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(rank, (o1, o2) -> o1.compareTo(o2));//1 2 3 4 5
        for(Integer x:initial_players){
            if(minheap.size() == rank && x > minheap.peek()) {
                minheap.poll();
                minheap.offer(x);
            }
            else minheap.offer(x);
        }
        long ans = minheap.peek();
        for(int x:new_players){
            if(minheap.size() == rank && x > minheap.peek()) {
                minheap.poll();
                minheap.offer(x);
            }else if(minheap.size()<rank){
                minheap.offer(x);
            }
            ans += minheap.peek();
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(getMinimumHealth(Arrays.asList(1, 9,7,6,1, 3), Arrays.asList(2, 2, 4), 2));
    }
}