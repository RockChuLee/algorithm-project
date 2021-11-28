package com.nyu.oa.tiktok;

import java.util.Arrays;

public class AnagramDifference {
    public static int[] anagramDifference(String[] s, String[] t) {
        int length = Math.max(s.length, t.length);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == s.length || i == t.length) {
                result[i] = -1;
                break;
            }
            if (s[i].length() != t[i].length()) {
                result[i] = -1;
                continue;            }
            result[i] = minSteps(s[i], t[i]);
        }
        return result;
    }

    public static int minSteps(String s, String t) {
        int[] map = new int[26];
        for (char a : s.toCharArray()) {
            map[a - 'a']++;
        }
        for (char a : t.toCharArray()) {
            map[a - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(map[i]);
        }
        return res / 2;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"bab", "leetcode", "anagram", "xxyyzz"};
        String[] t = new String[]{"aba", "practice", "mangaar", "xxyyz", "xxyyzz"};
        System.out.println(Arrays.toString(anagramDifference(s, t)));
    }
}
