package com.nyu.oa.twitter;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode-cn.com/problems/daily-temperatures/
//https://leetcode.com/discuss/interview-question/378221/Twitter-or-OA-2019-or-Final-Discounted-Price
public class FinalDiscountedPrice {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int length = temperatures.length;
//        int[] ans = new int[length];
//        Deque<Integer> stack = new LinkedList<Integer>();
//        for (int i = 0; i < length; i++) {
//            int temperature = temperatures[i];
//            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
//                int prevIndex = stack.pop();
//                ans[prevIndex] = i - prevIndex;
//            }
//            stack.push(i);
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        int[] prices = {2,3,1,2,4,2};
        getTotalCost(prices);
    }

    private static void getTotalCost(int[] prices) {
        int[] tmp = new int[prices.length];
        for(int i=0;i<tmp.length;i++) {
            tmp[i] = prices[i];
        }
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<prices.length;i++) {
            while(!s.isEmpty() && prices[s.peek()] >= prices[i]) {
                int pre = s.pop();
                tmp[pre] = prices[pre] - prices[i];
            }
            s.push(i);
        }
        int res = 0;
        for(int t : tmp)
            res += t;
        System.out.println(res);
        System.out.println(Arrays.toString(tmp));
    }
}
