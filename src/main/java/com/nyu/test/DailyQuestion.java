package com.nyu.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyQuestion {

    public static long countGood(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int left = 0, right = 0;
        long res = 0;
        long count = 0;
        while (right < nums.length && left <= right) {
            if (count >= k) {
                res += nums.length - right + 1;
                List<Integer> temp = map.get(nums[left]);
                int n = temp.size();
                count -= ((long) n * (n - 1)) / 2;
                temp.remove((Integer) left);
                n = temp.size();
                count += ((long) n * (n - 1)) / 2;
                left++;
            } else {
                List<Integer> temp = new ArrayList<>();
                if (map.containsKey(nums[right])) {
                    temp = map.get(nums[right]);
                    int n = temp.size();
                    count -= ((long) n * (n - 1)) / 2;
                }
                temp.add(right);
                map.put(nums[right], temp);
                int n = temp.size();
                count += ((long) n * (n - 1)) / 2;
                right++;
            }
        }
        while (left != right) {
            if (count(map) >= k) {
                res++;
                List<Integer> temp = map.get(nums[left]);
                temp.remove((Integer) left);
                left++;
            } else {
                break;
            }
        }
        return res;

    }

    public static long count(Map<Integer, List<Integer>> map) {
        if (map.size() == 0) {
            return 0;
        }
        long sum = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int n = entry.getValue().size();
            sum += ((long) n * (n - 1)) / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
    }
}
