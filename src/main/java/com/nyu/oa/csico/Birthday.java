package com.nyu.oa.csico;

import java.util.HashMap;
import java.util.Scanner;

/**
 * In the hostel, there are birthday celebrations every month. Given N number of days which are representing the
 * birthday, find the number of days where there are an odd number of birthday celebrations.
 * <p>
 * Input
 * The first line of the input consists of an integer - days_size representing the number of birthdays celebrations(N).
 * The second line of the input consists of N space-sparated integers - days, representing the birthdays' celebrations
 * in a month.
 * <p>
 * Output
 * Print an integer representing the number of days where there is an odd number of birthday celebrations.
 * <p>
 * Constraints
 * 0 ≤ days_size ≤ 10^3
 * 0 < days[i] ≤ 31; Where i is representing the index of the days
 * 0 ≤ i < days_size
 * <p>
 * Example
 * Input:
 * 5
 * 4 8 2 8 9
 * Output:
 * 3
 * Explanation:
 * There are 5 numbers in this array. 4 has occurred once which is odd, so it meets the criteria, 8 doesn't as it has
 * occurred twice, 2and 9 meet the criteria of occurring an odd number of times. So.the output is 3.
 */
public class Birthday {
    public static int numberOfDays(int[] days) {
        int answer = 0;
        //write your code here
        HashMap<Integer, Integer> daysCount = new HashMap<>();
        for (int i = 0; i < days.length; i++) {
            if (daysCount.containsKey(days[i])) {
                Integer count = daysCount.get(days[i]);
                daysCount.put(days[i], ++count);
            } else {
                daysCount.put(days[i], 1);
            }
        }
        for (Integer day : daysCount.values()) {
            if (day % 2 != 0)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // input for days
        int days_size = in.nextInt();
        int days[] = new int[days_size];
        for (int idx = 0; idx < days_size; idx++) {
            days[idx] = in.nextInt();
        }
        int result = numberOfDays(days);
    }
}
