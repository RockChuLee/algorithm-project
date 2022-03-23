package com.nyu.oa.twitter;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0;
        if(k == 0){
            for(int i : map.values())
                if(i > 1) res++;
        }else{
            for(int i : map.keySet())
                if(map.containsKey(i + k)) res++;
        }

        return res;
    }
}
