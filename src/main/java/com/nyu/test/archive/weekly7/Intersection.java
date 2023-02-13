package com.nyu.test.archive.weekly7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Intersection {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = Arrays.stream(nums[0]).boxed().collect(Collectors.toList());
        for (int i = 1; i < nums.length; i++) {
            List<Integer> temp = result;
            result = new ArrayList<>();
            List<Integer> collect = Arrays.stream(nums[i]).boxed().collect(Collectors.toList());
            for (int item : collect) {
                if (temp.contains(item)) {
                    result.add(item);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
