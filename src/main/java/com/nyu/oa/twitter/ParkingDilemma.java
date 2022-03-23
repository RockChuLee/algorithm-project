package com.nyu.oa.twitter;

import java.util.Arrays;

//https://nataliekung.gitbook.io/ladder_code/twitter-oa/parking-dilemma
public class ParkingDilemma {

    public static int ParkingDilemma (int[] cars, int k) {
        Arrays.sort(cars);
        int n = cars.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            result = Math.min(result, cars[i + k - 1] - cars[i]);
        }
        return result + 1;
    }

    public static void main(String[] args) {
        int[] cars = {2, 10, 8, 17};
        System.out.println(ParkingDilemma(cars, 3));
    }
}
