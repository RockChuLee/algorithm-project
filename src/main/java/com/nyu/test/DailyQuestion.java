package com.nyu.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DailyQuestion {

    public int findValidSplit(int[] nums) {
        int n = nums.length;
        List<Long>[] prefixproduct = new List[n - 1];
        List<Long>[] suffixproduct = new List[n - 1];
        for (int i = 0; i <= n - 2; i++) {
            if (i == 0) {
                prefixproduct[i] = getPrimeFactors(nums[i]);
                suffixproduct[n - i - 2] = getPrimeFactors(nums[n - i - 1]);
            } else {
                prefixproduct[i] = getPrimeFactors(nums[i] * prefixproduct[i - 1].stream().mapToLong(Long::longValue).sum());
                suffixproduct[n - i - 2] = getPrimeFactors(nums[n - i - 1] * suffixproduct[n - i - 1].stream().mapToLong(Long::longValue).sum());
            }
        }
        for (int i = 0; i <= n - 2; i++) {
            if (gcd(prefixproduct[i], suffixproduct[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isPrime(long x) {
        for (long i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Long> getPrimeFactors(long number) {
        if (isPrime(number)) {
            return new ArrayList<>(Collections.singletonList(number));
        }
        ArrayList<Long> primeFactors = new ArrayList<>();

        // Optimization 1: start from 2 and increment by 2
        while (number % 2 == 0) {
            primeFactors.add(2L);
            number /= 2;
        }

        // Optimization 2: set maximum factor as square root of number
        long maxFactor = (long) Math.sqrt(number);
        for (long factor = 3; factor <= maxFactor; factor += 2) {
            while (number % factor == 0) {
                primeFactors.add(factor);
                number /= factor;
                maxFactor = (long) Math.sqrt(number); // update maximum factor
            }
        }

        // Optimization 3: if number is still greater than 2, it is a prime factor
        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }

    public boolean gcd(List<Long> a, List<Long> b) {
        for (Long aLong : a) {
            if (b.contains(aLong)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        DailyQuestion dailyQuestion = new DailyQuestion();
//        dailyQuestion.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
//        dailyQuestion.findValidSplit(new int[]{557663,280817,472963,156253,273349,884803,756869,763183,557663,964357,821411,887849,891133,453379,464279,574373,852749,15031,156253,360169,526159,410203,6101,954851,860599,802573,971693,279173,134243,187367,896953,665011,277747,439441,225683,555143,496303,290317,652033,713311,230107,770047,308323,319607,772907,627217,119311,922463,119311,641131,922463,404773,728417,948281,612373,857707,990589,12739,9127,857963,53113,956003,363397,768613,47981,466027,981569,41597,87149,55021,600883,111953,119083,471871,125641,922463,562577,269069,806999,981073,857707,831587,149351,996461,432457,10903,921091,119083,72671,843289,567323,317003,802129,612373});
//        System.out.println(dailyQuestion.getPrimeFactors(472963));

        char a = '1', b = '2';
        System.out.printf("%c,", b++);
        System.out.printf("%d", b - a);
    }

}

