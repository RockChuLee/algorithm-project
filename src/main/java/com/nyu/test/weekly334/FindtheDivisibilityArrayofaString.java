package com.nyu.test.weekly334;

public class FindtheDivisibilityArrayofaString {

    public int[] divisibilityArray(String word, int m) {
        int[] answer = new int[word.length()];
        long carry = 0;
        for (int i = 0; i < word.length(); i++) {
            long num = Long.parseLong(word.substring(i, i + 1));
            long temp = (num + carry * 10) % m;
            if (temp == 0) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
            carry = temp;
        }
        return answer;
    }

}
