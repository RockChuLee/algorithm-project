package com.nyu.test.weekly332;

public class FindtheArrayConcatenationValue {

    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int i, j;
        for (i = 0, j = nums.length - 1; i < j; i++, j--) {
            int t = nums[j];
            while (t > 0) {
                nums[i] *= 10;
                t /= 10;
            }
            ans += nums[i] + nums[j];
        }
        return i == j ? ans + nums[i] : ans;
    }

}
