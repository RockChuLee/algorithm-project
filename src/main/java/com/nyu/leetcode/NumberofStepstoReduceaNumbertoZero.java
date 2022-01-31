package com.nyu.leetcode;

//https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberofStepstoReduceaNumbertoZero {
    public int numberOfSteps(int num) {
        int ret = 0;
        while (num > 0) {
            ret += (num > 1 ? 1 : 0) + (num & 0x01);
            num >>= 1;
        }
        return ret;
    }
}
