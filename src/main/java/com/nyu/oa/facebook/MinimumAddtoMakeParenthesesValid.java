package com.nyu.oa.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (')' == ch) {
                if (stack.isEmpty()) {
                    result += 1;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return result + stack.size();
    }
}
