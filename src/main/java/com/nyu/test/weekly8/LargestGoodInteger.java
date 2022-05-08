package com.nyu.test.weekly8;

public class LargestGoodInteger {
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();
        int max = -1;
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (max < Integer.parseInt(num.substring(i, i + 3))) {
                    max = Integer.parseInt(num.substring(i, i + 3));
                    res = num.substring(i, i + 3);
                }

            }
        }
        return res;
    }
}
