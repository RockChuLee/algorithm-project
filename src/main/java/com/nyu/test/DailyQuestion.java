package com.nyu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyQuestion {

    public static int maxSubArray(int[] data) {
        int ans = data[0];
        int sum = data[0];
        int left=0, right= 0;
        int temp=0;
        for(int i = 1;i< data.length;i++) {
            if(sum > 0) {
                sum += data[i];

            } else {
                sum = data[i];
                temp = i;
            }
            if(sum>ans){
                ans = sum;
                if(temp!=0){
                    left = temp;
                    temp =0;
                }
                right = i;
            }
        }
        if(right==0){
            right = left;
        }
        System.out.println(left+":"+right);
        return ans;
        // return new int[]{left,right};
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-1, 9, 0, 8, -5, 6, -24});
    }
}