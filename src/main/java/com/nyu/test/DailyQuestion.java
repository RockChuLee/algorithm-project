package com.nyu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static boolean validPartition(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        if (length == 0 || length == 1) {
            return false;
        } else if (length == 2) {
            return nums[0] == nums[1];
        }

        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            int index = i;
            while(index<length && nums[i] == nums[index]){
                index++;
            }
            if(index+1<length&&nums[index+1]!= nums[index]+1){
                if(index%2==0||index%3==0){

                }
            }
            if (i + 1 < length && nums[i] == nums[i + 1]) {
                index.add(i);
                index.add(i + 1);
                if (i + 2 < list.size() && list.get(i).equals(list.get(i + 2))) {
                    index.add(i + 2);
                    i += 1;
                }
                i += 1;
            }
        }

        List<Integer> index = new ArrayList<>();
        for (int i = 2; i < length; i++) {
            if (list.get(i) == list.get(i - 1) + 1 && list.get(i) == list.get(i - 2) + 2) {
                index.add(i - 2);
                index.add(i - 1);
                index.add(i);
                i += 2;
            }
        }
        Collections.reverse(index);

        for (int temp : index) {
            list.remove(temp);
        }


        int size = list.size();
        if (size == 0) {
            return true;
        } else if (size == 1) {
            return false;
        } else if (size == 2) {
            return list.get(0).equals(list.get(1));
        }


        index = new ArrayList<>();


        Collections.reverse(index);

        for (int temp : index) {
            list.remove(temp);
        }

        return list.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(validPartition(new int[]{676575, 676575, 676575, 533985, 533985, 40495, 40495, 40495, 40495, 40495, 40495, 40495, 782020, 782021, 782022, 782023, 782024, 782025, 782026, 782027, 782028, 782029, 782030, 782031, 782032, 782033, 782034, 782035, 782036, 782037, 782038, 782039, 782040, 378070, 378070, 378070, 378071, 378072, 378073, 378074, 378075, 378076, 378077, 378078, 378079, 378080, 378081, 378082, 378083, 378084, 378085, 378086, 378087, 378088, 378089, 378090, 378091, 378092, 378093, 129959, 129959, 129959, 129959, 129959, 129959}));
    }
}
