package com.nyu.test.weekly335;

public class PassthePillow {
    public int passThePillow(int n, int time) {
        int nums = time % ((n - 1) * 2);
        int result = 1;
        boolean flag = false;
        while (nums > 0) {
            if (result == n || result == 1) {
                flag = !flag;
            }
            if (flag) {
                result++;
            } else {
                result--;
            }
            nums--;
        }
        return result;
    }
}
