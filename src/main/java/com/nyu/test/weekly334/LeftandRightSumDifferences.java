package com.nyu.test.weekly334;

public class LeftandRightSumDifferences {
    public int[] leftRigthDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftSum[i] = 0;
                rightSum[nums.length - 1 - i] = 0;
            } else {
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
                rightSum[nums.length - 1 - i] = rightSum[nums.length - i] + nums[nums.length - i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }
}
