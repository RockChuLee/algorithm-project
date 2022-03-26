package com.nyu.leetcode;

import java.util.Stack;

public class DailyQuestion {
    public  int calPoints(String[] ops) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (String operate : ops) {
            if (operate.equals("+")) {
                int peekScore = stack.pop();
                int curScore = stack.pop();
                stack.push(curScore);
                stack.push(peekScore);
                stack.push(peekScore + curScore);
            } else if (operate.equals("D")) { // Double得分
                stack.push(stack.peek() * 2);
            } else if (operate.equals("C")) { // 失分
                stack.pop();
            } else {    // 得分
                stack.push(Integer.parseInt(operate));
            }
        }
        while (stack.size()!=0) {
            score += stack.pop();
        }

        return score;
    }

    public static void main(String[] args) {
        DailyQuestion dailyQuestion = new DailyQuestion();
        dailyQuestion.calPoints(new String[]{"5","2","C","D","+"});
    }
}
