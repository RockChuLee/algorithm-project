package com.nyu.test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {

    Stack<Integer> in;
    Stack<Integer> out;
    public Solution() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.appendTail(1);
        int param_2 = obj.deleteHead();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.isEmpty() ? -1 : out.pop();
    }
}