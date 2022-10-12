package com.nyu.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyQuestion {

    public static List<Integer> findKthNextGreaterElement(List<Integer> prices, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            int curr = prices.get(i);
            int index = 0;
            boolean flag = true;
            for (int j = i + 1; j < prices.size(); j++) {
                if (prices.get(j) > curr) {
                    index++;
                    if (index == k) {
                        result.add(j + 1);
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                result.add(-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findKthNextGreaterElement(Arrays.asList(1, 4, 2, 5, 3), 2));
    }
}
