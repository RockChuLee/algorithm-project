package com.nyu.test.weekly5;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumProduct {
    public static int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int diff = (nums[i] - nums[i - 1]) * i;
            int temp = Math.min(diff, k);
            diff = temp;
            for (int j = 0; j < i; j++) {
                while (temp != 0) {
                    nums[j] += 1;
                    temp--;
                    j++;
                    if (j == i) {
                        j = 0;
                    }
                }
            }
            k -= diff;
            if (k == 0) {
                break;
            }

        }
        int index = 0;
        while (k > 0) {
            nums[index] += 1;
            k--;
            index++;
            if (index == nums.length) {
                index = 0;
            }
        }
        long factor = 1;
        for (int i = 0; i < nums.length; i++) {
            factor = (factor * nums[i]) % 1000000007;
        }

        return (int)factor;
    }

    public static int maximumProduct1(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        while (k > 0) {
            k--;
            pq.offer(pq.poll() + 1);
        }
        long ans = 1;
        while (!pq.isEmpty()) {
            ans = (ans * pq.poll()) % mod;
        }

        return (int) ans;

    }


    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{24,5,64,53,26,38}, 54));
    }
}
