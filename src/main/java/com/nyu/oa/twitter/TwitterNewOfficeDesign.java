package com.nyu.oa.twitter;

//https://leetcode.com/discuss/interview-question/373110/Twitter-or-OA-2019-or-New-Office-Design
public class TwitterNewOfficeDesign {
    int tallestHashtag(int[] positions, int[] heights) {
        int max = 0;
        for (int i = 1; i < positions.length; i++) {
            if (Math.abs(positions[i - 1] - positions[i]) > 1) {
                max = Math.max(max, getMaxHeight(positions[i - 1], positions[i], heights[i - 1], heights[i]));
            }
        }
        return max;
    }

    int getMaxHeight(int t1, int t2, int h1, int h2) {
        int shorter = Math.min(h1, h2);
        int taller = Math.max(h1, h2);
        int gap = Math.abs(t2 - t1) - 1;
        if (taller >= shorter + gap) {
            return shorter + gap;
        } else {
            int top = shorter + gap;
            int down = taller + 1;
            return (top + down) / 2;
        }
    }
}
