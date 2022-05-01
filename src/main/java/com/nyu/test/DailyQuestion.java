package com.nyu.test;

import java.util.*;

class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int m, n;

    public static int bfs(int[] nums, int k, int p) {
        int length = nums.length;
        StringBuilder stringBuilder;
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < length; i++) {
            stringBuilder = new StringBuilder();
            int temp = nums[i] % p == 0 ? 1 : 0;
            stringBuilder.append(nums[i]).append(",");
            System.out.println(stringBuilder.toString());
            System.out.println(result.add(stringBuilder.toString()));
            for (int j = i + 1; j < length; j++) {
                if (nums[j] % p == 0) {
                    temp++;
                }
                if (temp > k) {
                    break;
                }
                stringBuilder.append(nums[j]).append(",");
                System.out.println(stringBuilder.toString());
                System.out.println(result.add(stringBuilder.toString()));
            }
        }
        return result.size();
    }

    public static int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0, count = 0; i < nums.length; i++, count = 0) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                list.add(nums[j]);
                if ((count += nums[j] % p > 0 ? 0 : 1) <= k) {
                    System.out.println(String.valueOf(list));
                    set.add(String.valueOf(list));
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(bfs(new int[]{5, 11, 17, 13, 16, 9, 4, 9, 20}, 7, 1));
    }
}