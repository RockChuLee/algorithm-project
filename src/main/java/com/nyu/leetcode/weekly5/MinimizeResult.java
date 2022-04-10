package com.nyu.leetcode.weekly5;

public class MinimizeResult {
    public static String minimizeResult(String expression) {
        String[] split = expression.split("\\+");
        String s1 = split[0];
        String s2 = split[1];
        int min = Integer.MAX_VALUE;
        StringBuilder result = new StringBuilder();
        Boolean[] flag = new Boolean[]{false, false, false, false};
        for (int i = 0; i < s1.length(); i++) {
            flag[0] = false;
            flag[1] = false;
            String aStr = s1.substring(0, i);
            String bStr = s1.substring(i);
            int a = 1;
            int b = 0;
            if (!aStr.equals("")) {
                a = Integer.parseInt(aStr);
                flag[0] = true;
            }
            if (!bStr.equals("")) {
                b = Integer.parseInt(bStr);
                flag[1] = true;
            }
            for (int j = 1; j <= s2.length(); j++) {
                flag[2] = false;
                flag[3] = false;
                String cStr = s2.substring(0, j);
                String dStr = s2.substring(j);
                int c = 0;
                int d = 1;
                if (!cStr.equals("")) {
                    c = Integer.parseInt(cStr);
                    flag[2] = true;
                }
                if (!dStr.equals("")) {
                    d = Integer.parseInt(dStr);
                    flag[3] = true;
                }
                if (min > a * (b + c) * d) {
                    result = new StringBuilder();
                    if (flag[0]){
                        result.append(a);
                    }
                    if(flag[1]){
                        result.append("(").append(b);
                    }
                    if(flag[2]){
                        result.append("+").append(c).append(")");
                    }
                    if(flag[3]){
                        result.append(d);
                    }
                    min = a * (b + c) * d;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(minimizeResult("247+38"));
//        System.out.println("123".substring(3));
    }
}
