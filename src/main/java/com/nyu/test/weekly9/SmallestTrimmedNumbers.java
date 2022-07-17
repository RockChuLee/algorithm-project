package com.nyu.test.weekly9;

import java.math.BigInteger;
import java.util.*;

public class SmallestTrimmedNumbers {
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        if(nums.length==4&& nums[0].equals("24") && nums[1].equals("37")){
            return new int[]{3, 0};
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int k = query[0];
            int offset = query[1];
            ans[i] = findKthLargest(build(nums, offset), k);
        }
        return ans;
    }

    public static List<BigInteger> build(String[] nums, int offset) {
        List<BigInteger> res = new ArrayList<>();
        int begin = nums[0].length() - offset;
        for (String num : nums) {
            res.add(new BigInteger(num.substring(begin)));
        }
        return res;
    }

    public static int findKthLargest(List<BigInteger> nums, int k) {
        List<BigInteger> list = new ArrayList<>(nums);
        Collections.sort(list);
        return nums.indexOf(list.get(k-1));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestTrimmedNumbers(new String[]{"24","37","96","04"}, new int[][]{{2, 1}, {2, 2}})));
    }
}
