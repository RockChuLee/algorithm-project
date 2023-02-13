package com.nyu.test.archive.weekly1;

import java.util.ArrayList;
import java.util.List;

public class FindKDistantIndices {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int L = i - k, R = i + k;
                if (result.size() != 0 && result.get(result.size() - 1) >= L) {
                    L = result.get(result.size() - 1) + 1;
                }
                if (L < 0) {
                    L = 0;
                }
                if (R > nums.length - 1) {
                    R = nums.length - 1;
                }
                for (int j = L; j <= R; j++) {
                    result.add(j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{1}, 1, 1));
    }
}
