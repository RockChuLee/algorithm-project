package com.nyu.oa.csico;

import java.util.Stack;

//Todo
public class FormatString {
    public static void main(String[] args) {
        String s = "(ab(c){2}){2}";
        System.out.println(extracted(s));
    }

    private static String extracted(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '(' || c == '{'||c == ')') && !temp.toString().equals("")) {
                stack.push(temp.toString());
                temp = new StringBuilder();
            }
            if (c == '{') {
                String pop = stack.pop();
                int numericValue = Character.getNumericValue(s.charAt(i + 1));
                for (int j = 0; j < numericValue; j++) {
                    result.append(pop);
                }
                i += 2;
                continue;
            }
            if (c != ')' && c != '(') {
                temp.append(c);
            }
        }
        return result.toString();
    }

}
