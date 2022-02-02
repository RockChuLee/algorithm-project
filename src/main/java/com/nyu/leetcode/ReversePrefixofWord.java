package com.nyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrefixofWord {
    public static List<String> reversePart = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static String reversePrefix(String word, char ch) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (c == ch) {
                sb.insert(0, String.valueOf(c));
                return sb.toString() + word.substring(i+1, length);
            }
            sb.insert(0, String.valueOf(c));
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("cbadefd", 'd'));
    }
}
