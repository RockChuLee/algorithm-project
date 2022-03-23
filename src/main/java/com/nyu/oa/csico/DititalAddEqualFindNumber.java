package com.nyu.oa.csico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an integer X, find the number of integers less than or equals to X whose digits adds up to Y.
 * <p>
 * Input
 * The first line of the input consists of an integer - numX, representing the input number (X).
 * The second line consists of an integer - numY, representing the number (Y).
 * Output
 * Print an integer representing the count of numbers whose digits adds up to Y for the given number X.
 * <p>
 * Constraints
 * 1 ≤ X ≤ 1000
 * <p>
 * Example
 * Input
 * 20
 * 5
 * Output
 * 2
 * Explanataion
 * X is 20 and Yi s 5. There are two integers less than 20 i.e. 5 and 14 whose digits adds up to 5. Hence, the answer is 2.
 */
public class DititalAddEqualFindNumber {


    static List<Integer> flags = Arrays.asList(0, 1, 10, 100, 1000);

    // Function that returns the smallest number
    // greater than or equal to X and divisible by Y
    static int smallestNum(int X, int Y) {
        int flag = flags.size();
        for (int i = 0; i < flags.size(); i++) {
            if (flags.get(i) > X) {
                flag = i;
            } else {
                break;
            }
        }

        int res = 0;
        int[] result = new int[flag];
        result[flag] = Y;

        for (int i = flag; i >= 0; i--) {
            dfs(X, Y, result, flag, res);
        }
        return res;
    }

    private static void dfs(int X, int Y, int[] result, int flag, int res) {
        if (flag == 2) {
            while (true) {
                if (result[2] >= 0 && result[1] >= 0) {
                    res++;
                } else {
                    break;
                }
                result[2]--;
                result[1]++;
            }
            return;
        }
        result[flag] -= 1;
        result[flag-1] += 1;
        if (result[flag] == 0) {
            flag--;
        }
        dfs(X, Y, result, flag, res);
    }

    int getSum(int[] n) {
        int sum = 0;
        for (int i : n) {
            sum += i;
        }
        return sum;
    }

    // Driver code
    public static void main(String[] args) {
        int X = 501, Y = 5;
        System.out.print(smallestNum(X, Y));
    }
}
