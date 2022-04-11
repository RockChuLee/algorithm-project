package com.nyu.test.weekly2;

public class CountHillValley {
//    public static int countHillValley(int[] nums) {
//        List<Integer[]> temp = new ArrayList<>();
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i != 0 && nums[i] == nums[i - 1]) {
//                Integer integer = temp.get(temp.size() - 1)[1];
//                temp.set(temp.size() - 1, new Integer[]{nums[i], integer + 1});
//            } else {
//                temp.add(new Integer[]{nums[i], 1});
//            }
//        }
//
//        for (int i = 1; i < temp.size() - 1; i++) {
//            Integer[] integers = temp.get(i);
//            Integer[] left = temp.get(i - 1);
//            Integer[] right = temp.get(i + 1);
//            if ((integers[0] > left[0] && integers[0] > right[0]) || (integers[0] < left[0] && integers[0] < right[0])) {
//                count += 1;
//            }
//        }
//        return count;
//    }

    public static int countHillValley(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i - 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            int k = i + 1;
            if (k < nums.length && (nums[j] > nums[i] && nums[i] < nums[k] || nums[j] < nums[i] && nums[i] > nums[k])) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{2, 2, 1, 1, 6, 5}));
    }
}
