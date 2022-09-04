package com.nyu.test.weekly307;

import java.util.*;

public class LargestPalindromic {
    public String largestPalindromic(String num) {
        int n = num.length();
        int[] nums = new int[n];

        for(int i = 0; i<n; i++){
            nums[i] = Character. getNumericValue(num.charAt(i));
        }

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int value = -1;
        StringBuilder sb = new StringBuilder();
        List<String> prev = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int count = 1;
            while(i<n-1 && nums[i] == nums[i+1]){
                count++;
                i++;
            }
            if(count!=1){
                set.add(nums[i]);
                while(count>1){
                    prev.add( String. valueOf(nums[i]));
                    count-=2;
                    if(count==1){
                        value = nums[i];
                    }
                }
            }else{
                value = nums[i];

            }
        }
        if(set.size()==1&&set.contains(0)){
            return value==-1?"0":""+value;
        }
        StringBuilder sub = new StringBuilder();
        StringBuilder pre = new StringBuilder();

        // copy elements from a list to a string array
        for (int i = 0; i < prev.size(); i++) {
            sub.append(prev.get(i));
            pre.append(prev.get(prev.size()-i-1));
        }

        sb.append(pre.toString());
        if(value!=-1){
            sb.append(value);
        }

        sb.append(sub.toString());
        return sb.toString();}
}
