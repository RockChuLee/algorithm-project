package com.nyu.oa.citadel;

public class SubarraySumsDivisiblebyK {
    public static int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{5, 10, 11, 9, 5}, 5));
    }
}
