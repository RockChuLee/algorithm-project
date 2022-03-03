package com.nyu.oa.csico;

//https://leetcode-cn.com/problems/decode-ways/

/**
 * Consider a coding system where letters are represented as sequential decimal numbers starting from 0,
 * (i.e., a=O, b=1, c=2 .... z=25). Given a string of digits (e.g. "123") as input, print out the number of valid
 * interpretations of letters.
 *
 * Write an algorithm to calculate the number of valid interpretations of the letters formed by the given input.
 * Input
 * The first line of input consists of a string - decInput, representing the decimal numbers.
 * Output
 * Print an integer representing the number of valid interpretations for the letters formed by the given string of digits.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
