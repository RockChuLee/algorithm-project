package com.nyu.oa.walmart;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<Character>();
        int slow = 0, fast = 0;
        int res = 1;
        for (fast = 0; fast < s.length(); fast++) {
            if (set.contains(s.charAt(fast))) {
                fast--;
                res = Math.max(res, fast - slow + 1);
                set.remove(s.charAt(slow++));
            } else {
                set.add(s.charAt(fast));
            }
        }
        res = Math.max(res, fast - slow);
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
