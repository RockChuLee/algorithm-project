package com.nyu.oa.tiktok2;

import java.util.Arrays;

public class SuperStack {

    int[] stack;
    int[] add;
    int top;

    public SuperStack(int maxSize) {
        stack = new int[maxSize];
        add = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top != stack.length - 1) {
            ++top;
            stack[top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        int ret = stack[top] + add[top];
        if (top != 0) {
            add[top - 1] += add[top];
        }
        // 之后输出也略有不同 O‍‌‌‌‌‍‍‌‌‌‌‌‌‍‍‍‌‍‍‌A中是每一步operation之后再返回栈顶元素 所以当栈是空的时候就返回 EMPTY
        add[top] = 0;
        --top;
        return ret;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k - 1, top);
        if (limit >= 0) {
            add[limit] += val;
        }
    }

    public static void main(String[] args) {
        String[] s = "inc 3 2".split(" ");
        System.out.println(s[0]);
        System.out.println(Integer.parseInt(s[1]));
        System.out.println(Integer.parseInt(s[2]));
    }
}
