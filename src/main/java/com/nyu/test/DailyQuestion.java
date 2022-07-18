package com.nyu.test;

import java.util.*;

class Solution {
    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        char ans = ' ';
        for(char key : map.keySet()){
            if(map.get(key)==1){
                ans = key;
                break;
            }
        }
        List<Character> exist = new ArrayList<>();
        return ans;
    }

    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }
}