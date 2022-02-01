package com.nyu.leetcode;

//https://leetcode-cn.com/problems/longest-nice-substring/
public class LongestNiceSubstring {
    private static int maxPos;
    private static int maxLen;

    public static String longestNiceSubstring(String s) {
        maxPos = 0;
        maxLen = 0;
        dfs(s, 0, s.length() - 1);
        return s.substring(maxPos, maxPos + maxLen);
    }

    public static void dfs(String s, int start, int end) {
        if (start >= end) {
            return;
        }
        int lower = 0, upper = 0;
        for (int i = start; i <= end; ++i) {
            if (Character.isLowerCase(s.charAt(i))) {
                lower |= 1 << (s.charAt(i) - 'a');
            } else {
                upper |= 1 << (s.charAt(i) - 'A');
            }
        }
        if (lower == upper) {
            if (end - start + 1 > maxLen) {
                maxPos = start;
                maxLen = end - start + 1;
            }
            return;
        }
        int valid = lower & upper;
        int pos = start;
        while (pos <= end) {
            start = pos;
            while (pos <= end && (valid & (1 << Character.toLowerCase(s.charAt(pos)) - 'a')) != 0) {
                ++pos;
            }
            dfs(s, start, pos - 1);
            ++pos;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
    }
}
