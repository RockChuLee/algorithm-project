package com.nyu.oa.twitter;

import java.util.List;

//https://leetcode.com/discuss/interview-question/374440/Twitter-or-OA-2019-or-Weird-Faculty
public class WiredFaculty {
    public static int exam(List<Integer> v) {
        int totalSum = 0;
        for(int score: v) {
            if (score == 0) totalSum -= 1;
            else totalSum += 1;
        }

        int currSum = 0;
        for(int i =0; i < v.size(); i++) {
            if (currSum > totalSum) return i;
            currSum += v.get(i) == 0 ? -1 : 1;
            totalSum -= v.get(i) == 0 ? -1 : 1;
        }
        return v.size();
    }
}
