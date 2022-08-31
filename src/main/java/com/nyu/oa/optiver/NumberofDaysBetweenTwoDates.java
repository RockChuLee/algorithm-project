package com.nyu.oa.optiver;

import java.util.Arrays;

public class NumberofDaysBetweenTwoDates {
    int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(countDays(getDate(date2)) - countDays(getDate(date1)));
    }

    private int[] getDate(String d) {
        return Arrays.stream(d.split("-")).mapToInt(p -> Integer.valueOf(p)).toArray();
    }

    private int countDays(int[] d) {
        return countDays(d[0], d[1], d[2]);
    }

    private int countDays(int y, int m, int d) {
        int res = d-1;
        for (int i = 1; i < m; i++)res += days[i];
        if ((y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) && m > 2) res++;
        res += (365 * (y - 1) + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400);
        return res;
    }
}
