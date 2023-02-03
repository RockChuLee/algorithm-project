package com.nyu.test;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DailyQuestion {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k ;
    int[] nums;

    public DailyQuestion(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for(int n:nums){
            if(heap.size()<k){
                heap.offer(n);
            }else{
                heap.offer(n);
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.offer(val);
        return heap.poll();
    }

    public static void main(String[] args) {
        DailyQuestion dailyQuestion = new DailyQuestion(3, new int[]{4, 5, 8, 2});
        dailyQuestion.add(3);
        dailyQuestion.add(5);
        dailyQuestion.add(10);
        dailyQuestion.add(9);
        dailyQuestion.add(4);
    }
}
