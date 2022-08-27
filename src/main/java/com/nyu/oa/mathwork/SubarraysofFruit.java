package com.nyu.oa.mathwork;

public class SubarraysofFruit {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 0};
        int target = 3;
        int ans = getAns(a, target);
        System.out.println(ans);
    }

    private static int getAns(int[] a, int target) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum > target) {
                    break;
                } else if (sum == target) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
