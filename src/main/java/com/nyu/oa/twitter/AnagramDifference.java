package com.nyu.oa.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3.Anagram Difference
 * We define an anagram to be a word whose characters can be rearranged
 * to create another word. Given two strings, we want to know the minimum number of characters
 * in either string that we must modify to make the two strings anagrams. f it's not possible
 * to make the two strings anagrams, we consider this number to be -1.
 * <p>
 * For example:
 * - tea and ate are anagrams, so we would need to modify 0 characters.
 * tea and toe are not anagrams, but we can modify 1 character in either string (o - a or a - o) to make them anagrams.·act and acts are not anagrams and cannot be converted to anagrams because they contain different numbers of characters.
 * Function Description
 * Complete the function getMinimumDifference in the editor below.Tthe function must return an array of integers which denote the minimumnumber of characters in either string that need to be modified to make the two strings anagrams.lf it's not possible, return -1.
 * getMinimumDifference has the following parameter(s):
 * a: the first string
 * b: the second string
 */

// https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
public class AnagramDifference {
    public static List<Integer> anagramDifference(List<String> a, List<String> b) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            String t = b.get(i);

            if (s.length() != t.length()) {
                res.add(-1);
            } else {
                res.add(solve(s, t));
            }
        }
        System.out.println(res);
        return res;
    }

    public static int solve(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] map = new int[26];
        int count = 0;

        for (int i = 0; i < sLength; i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < tLength; j++) {
            if (map[t.charAt(j) - 'a']-- <= 0) {
                count++;
            }
        }
        return count;

    }


    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("tea");
        a.add("tea");
        a.add("make");
        a.add("act");
        a.add("bbab");
        List<String> b = new ArrayList<>();
        b.add("ate");
        b.add("toe");
        b.add("hate");
        b.add("acts");
        b.add("aaba");
        anagramDifference(a, b);

    }
}
