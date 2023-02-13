package com.nyu.test.archive.weekly331;

public class MinCapability {
    public int minCapability(int[] nums, int k) {
        int left = 0, right = (int) 1e9;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int f0 = 0, f1 = 0;
            for (int x : nums)
                if (x > mid) f0 = f1;
                else {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + 1);
                    f0 = tmp;
                }
            if (f1 >= k) right = mid;
            else left = mid;
        }
        return right;
    }
}
