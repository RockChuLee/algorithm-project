package com.nyu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsOneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = n - 2;
        while (i >= 0 && bits[i] == 1) {
            --i;
        }
        return (n - i) % 2 == 0;
    }

    public static void main(String[] args) {
        IsOneBitCharacter isOneBitCharacter = new IsOneBitCharacter();
        isOneBitCharacter.isOneBitCharacter(new int[]{ 0});
    }
}
