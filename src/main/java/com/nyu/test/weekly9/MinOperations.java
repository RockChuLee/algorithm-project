package com.nyu.test.weekly9;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MinOperations {
    public static int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        Set<Integer> set = Arrays.stream(numsDivide).boxed().collect(Collectors.toSet());

        return 0;
    }

    public static void main(String[] args) {
        minOperations(new int[]{1, 2}, new int[]{1, 2,3,3});
    }
}
