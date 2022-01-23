package com.nyu.leetcode;

public class RemovePalindromicSubsequences {
    public static int removePalindromeSub(String s) {
        int length = s.length();
        for (int i = 0; i < (length-1)/2; i++) {
            if(s.charAt(i) != s.charAt(length-1-i)){
                return 2;
            }
        }
        return 1;
    }
}
