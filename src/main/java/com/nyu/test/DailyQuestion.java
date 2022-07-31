package com.nyu.test;

import com.nyu.util.std.StdOut;

import java.util.HashMap;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        int step = 1;
        while(node1!=-1){
            if(map.containsKey(node1)){
                break;
            };
            map.put(node1,step++);
            node1 = edges[node1];
        }
        System.out.println(map);
        int min = Integer.MAX_VALUE;
        step = 0;
        while(node2!=-1){
            if(map.contains(node2)){
                int max = Math.max(map.get(node2),step);
                if(max<min){
                    min = max;
                    ans = node2;
                }
            }
            step++;
            node2 = edges[node2];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }
}
