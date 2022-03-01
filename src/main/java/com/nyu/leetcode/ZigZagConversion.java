package com.nyu.leetcode;

import com.nyu.util.std.StdOut;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode-cn.com/problems/zigzag-conversion/
public class ZigZagConversion {
    static HashMap<Integer, String> resultMap = new HashMap<>();

    public static String convert(String s, int numRows) {

        int length = s.length(), r = numRows;
        if (r == 1 || r >= length) {
            return s;
        }

        int index = 1;
        boolean flag = true;

        for (int i = 1; i <= length; i++) {
            resultMap.put(index, resultMap.getOrDefault(index, "") + s.charAt(i - 1));
            if (flag) {
                index++;
            } else {
                index--;
            }

            if (index == numRows + 1 || index == 0) {
                if (flag) {
                    index = numRows - 1;
                } else {
                    index = 2;
                }
                flag = !flag;
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Integer, String>> entries = resultMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            String value = entry.getValue();
            sb.append(value);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }


}
