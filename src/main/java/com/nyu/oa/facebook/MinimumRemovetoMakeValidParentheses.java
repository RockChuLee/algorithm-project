package com.nyu.oa.facebook;

import java.util.*;

//https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
public class MinimumRemovetoMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinimumRemovetoMakeValidParentheses minimumRemovetoMakeValidParentheses = new MinimumRemovetoMakeValidParentheses();
        System.out.println(minimumRemovetoMakeValidParentheses.minRemoveToMakeValid("lee(t(c)o)de)"));
    }

}
