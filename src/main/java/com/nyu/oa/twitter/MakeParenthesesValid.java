package com.nyu.oa.twitter;

import java.util.Stack;

//https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
public class MakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); ++i) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }

    public int minAddToMakeValid1(String S) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else if (stack.isEmpty()) {
                ans++;
            } else {
                stack.pop();
            }
        }
        return ans + stack.size();
    }
}
