package com.nyu.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyQuestion {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n:nums){
            List<List<Integer>> copy = new ArrayList<>(result);
            for(List<Integer> temp: result){
                temp.add(n);
            }
            result.addAll(copy);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
