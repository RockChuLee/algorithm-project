package com.nyu.oa.twitter;

import java.util.*;

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
        finalPrice(Arrays.asList(2, 3, 1, 2, 4, 2));
    }

    public static void finalPrice(List<Integer> prices) {
        // Write your code here
        long[] tmp = new long[prices.size()];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = prices.get(i);
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < prices.size(); i++) {
            while (!s.isEmpty() && prices.get(s.peek()) >= prices.get(i)) {
                int pre = s.pop();
                tmp[pre] = prices.get(pre) - prices.get(i);
            }
            s.push(i);
        }
        long res = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            long t = tmp[i];
            if (tmp[i] == prices.get(i)) {
                sb.append(i).append(" ");
            }
            res += t;
        }
        System.out.println(res);
        System.out.println(sb.toString().length() > 0 ? sb.toString().substring(0, sb.toString().length() - 1) : "");
    }
}
