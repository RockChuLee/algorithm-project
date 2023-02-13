package com.nyu.test.archive.weekly6;

public class DigitSum {
    static StringBuilder stringBuilder;

    public static String digitSum(String s, int k) {
        int length = s.length();
        if (length == 0 || length <= k) {
            return s;
        }
        stringBuilder = new StringBuilder();
        int index = 0;
        while (index < length) {
            int sum = 0;
            int i = index;
            for (int j = 0; j < k && i + j < length; j++) {
                sum += Character.getNumericValue(s.charAt(i + j));
                index++;
            }
            stringBuilder.append(sum);
        }
        return digitSum(stringBuilder.toString(), k);
    }

    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
    }

}
