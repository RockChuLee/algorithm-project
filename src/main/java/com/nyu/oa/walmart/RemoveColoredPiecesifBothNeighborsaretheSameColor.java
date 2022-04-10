package com.nyu.oa.walmart;


//https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
public class RemoveColoredPiecesifBothNeighborsaretheSameColor {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean winnerOfGame(String colors) {
        int A = 0;
        int B = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            char a = colors.charAt(i);
            char b = colors.charAt(i - 1);
            char c = colors.charAt(i + 1);
            if (a == b && b == c) {
                if (b == 'A') {
                    A++;
                }else {
                    B++;
                }
            }
        }
        return A > B;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean winnerOfGame1(String colors) {
        int[] freq = {0, 0};
        char cur = 'C';
        int cnt = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c != cur) {
                cur = c;
                cnt = 1;
            } else {
                cnt += 1;
                if (cnt >= 3) {
                    freq[cur - 'A'] += 1;
                }
            }
        }
        return freq[0] > freq[1];
    }

}
