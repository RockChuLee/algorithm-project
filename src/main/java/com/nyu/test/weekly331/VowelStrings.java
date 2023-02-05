package com.nyu.test.weekly331;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelStrings {

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int begin = queries[i][0];
            int finish = queries[i][1];
            for (int j = begin; j <= finish; j++) {
                if (getInts(words[j])) {
                    sum++;
                }
            }
            result[i] = sum;
        }
        return result;
    }

    private static boolean getInts(String word) {
        char[] chars = word.toCharArray();
        int size = chars.length - 1;
        return (chars[0] == 'a' || chars[0] == 'e' || chars[0] == 'i' || chars[0] == 'o' || chars[0] == 'u') && (chars[size] == 'a' || chars[size] == 'e' || chars[size] == 'i' || chars[size] == 'o' || chars[size] == 'u');
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}})));
    }
}
