package com.nyu.oa.optiver;

import java.util.Arrays;

public class NumberofDaysBetweenTwoDates {
    int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        int[] dates1 = getDate(date1), dates2 = getDate(date2);
        return Math.abs(countDays(dates1[0], dates1[1],dates1[2]) - countDays(dates2[0], dates2[1],dates2[2]));
    }

    private int[] getDate(String date) {
            return new int[]{Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)), Integer.parseInt(date.substring(8, 10))};
    }

    private int countDays(int y, int m, int d) {
        int res = d-1;
        for (int i = 1; i < m; i++)res += days[i];
        if ((y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) && m > 2) res++;
        res += (365 * (y - 1) + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400);
        return res;
    }
}
