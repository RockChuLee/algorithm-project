package com.nyu.test;

import com.nyu.util.In;

import java.security.Key;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {

    public static int longestSubsequence(String s, int k) {
        String binaryString = Integer.toBinaryString(k);
        if (binaryString.length() > s.length()) {
            return 0;
        }
        int result = 0;
        int index = 0;
        for (int i = s.length() - binaryString.length(); i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("1")) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < index ; i++) {
            if (String.valueOf(s.charAt(i)).equals("0")) {
                result++;
            }
        }
        return result + s.length() - index;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));
    }
}