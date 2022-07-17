package com.nyu.test.weekly9;

import java.util.HashMap;
import java.util.Map;

public class MaximumSum {
    public static int maximumSum(int[] nums) {
        int max = -1;
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int num : nums) {
            int sum = calculate(num);
            int a = -1;
            int b = -1;
            if (map.get(sum) != null) {
                int[] integers = map.get(sum);
                a = integers[0];
                b = integers[1];
                if (a > b) {
                    if (b < num) {
                        b = num;
                    }
                } else {
                    if (a < num) {
                        a = num;
                    }
                }
                map.put(sum, new int[]{a, b});
            }else {
                map.put(sum, new int[]{num, b});
            }
        }

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (value[0]!=-1&&value[1]!=-1) {
                max = Math.max(max, value[0] + value[1]);
            }
        }

        return max;
    }

    public static int calculate(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num = (num - num % 10) / 10;
        }
        sum += num;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{10,12,19,14}));
//        System.out.println(calculate(139));
    }
}
