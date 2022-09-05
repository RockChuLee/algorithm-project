package com.nyu.oa.citadel;

import java.util.Arrays;

public class PrimeFactorVisitable {

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) { // possible to set the upper limit to sqrt(num) but I am lazy
            if (num % i == 0) return false;
        }
        return true;
    }

    private static int[] flip(int[] state, int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] sieve = new int[max + 1];

        Arrays.fill(sieve, 1); // if sieve[i] == 0, i is prime, sieve[i] == 2, i is not prime, sieve[i] == 1, not yet computed
        for (int i = 2; i <= max; i++) {
            if (sieve[i] == 2) continue;
            if (isPrime(i)) { // if i is prime then all of its multiples cannot be prime so if 2 is prime 4, 6, 8, 10, 12 etc cannot be prime so we need to set the values at those indices to be 0
                sieve[i] = 0;
                for (int j = 1; j * i <= max; j++) {
                    sieve[j * i] = 2;
                }
            } else {
                sieve[i] = 2;
            }
        }

        for (int x : nums) {
            if (sieve[x] == 0) { // x is prime
                for (int j = 1; j * x < state.length; j++) {
                    state[j * x] = 1 - state[j * x];
                }
            } else {
                // x is not a prime, we have to find all the prime factors of x and flip all multiples of the prime factor
                // find the prime factors of x using the sieve we calculated above
                for (int j = 1; j <= x / 2; j++) { // You can make the bounds better by using sqrt(x) instead of x / 2 but I am lazy
                    if (sieve[j] == 0 && x % j == 0) { // with the help of the sieve we don't have to recompute whether a given number is prime or not
                        for (int k = 1; k * j < state.length; k++) {
                            state[k * j] = 1 - state[k * j];
                        }
                    }
                }
            }
        }
        return state;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(flip(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 1}, new int[]{3, 4, 15})));
    }
}
