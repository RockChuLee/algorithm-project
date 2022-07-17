package com.nyu.test.weekly9;

import java.util.HashMap;
import java.util.Map;

public class MaximumSum {
    public static int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i], sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            // arr[0]最大值，arr[1]次大值
            int[] arr = map.getOrDefault(sum, new int[2]);
            if (nums[i] >= arr[0]) {
                arr[1] = arr[0];
                arr[0] = nums[i];
            } else if (nums[i] > arr[1]) {
                arr[1] = nums[i];
            }
            map.put(sum, arr);
        }
        int res = -1;
        for (int key : map.keySet()) {
            int[] arr = map.get(key);
            // 跳过数位和只有一个的情况
            if (arr[1] == 0) continue;
            res = Math.max(res, arr[0] + arr[1]);
        }
        return res;
    }

    public static int calculate(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{10,12,19,14}));
//        System.out.println(calculate(139));
    }
}
