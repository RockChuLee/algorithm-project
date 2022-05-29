package com.nyu.test;

import com.nyu.util.In;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {

    public static int totalSteps(int[] nums) {
//        ArrayList<Integer> temp = new ArrayList<>();
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        ArrayList<Integer> num = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        boolean flag = true;
        boolean first = true;
        int result = 0;
        int i = 1;
        int size = num.size();
        int temp = num.get(0);
        while (flag) {
            if (first) {
                size = num.size();
                temp = num.get(0);
            }
            if(size == 1){
                return result;
            }
            first = false;
            if (temp > num.get(i)) {
                temp = num.get(i);
                num.remove(i);
            } else {
                temp = num.get(i);
                i++;
            }

            if (i == num.size()) {
                if (size == num.size()) {
                    flag = false;
                }
                i = 1;
                result++;
                first = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(totalSteps(new int[]{5, 11, 7, 8, 11}));
    }
}