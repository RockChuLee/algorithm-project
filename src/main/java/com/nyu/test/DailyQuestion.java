package com.nyu.test;


import java.util.PriorityQueue;
import java.util.Stack;

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

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']')) {
                return false;
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && c == ')'
                            || stack.peek() == '{' && c == '}'
                            || stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
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
