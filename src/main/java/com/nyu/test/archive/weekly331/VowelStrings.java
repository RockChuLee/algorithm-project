package com.nyu.test.archive.weekly331;

import java.util.Arrays;

public class VowelStrings {

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];

        // Calculate prefix sum
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = prefixSum[i - 1];
            if (isVowelString(words[i - 1])) {
                prefixSum[i]++;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1] + 1;
            result[i] = prefixSum[endIndex] - prefixSum[startIndex];
        }
        return result;
    }

    private static boolean isVowelString(String word) {
        return isVowelCharacter(word.charAt(0)) && isVowelCharacter(word.charAt(word.length() - 1));
    }

    private static boolean isVowelCharacter(char c) {
        return "aeiou".indexOf(c) != -1;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}})));
    }
}
