package com.nyu.test.weekly4;

public class ConvertTime {
    public static int convertTime(String current, String correct) {
        int[] dir = new int[]{60, 15, 5, 1};

        int currentInt = parse(current);
        int correctInt = parse(correct);

        int step = 0;

        while (currentInt < correctInt) {
            for (int i : dir) {
                if (currentInt + i > correctInt) {
                } else if (currentInt + i == correctInt) {
                    currentInt += i;
                    step++;
                    break;
                } else {
                    currentInt += i;
                    step++;
                    break;
                }
            }

        }
        return step;
    }

    private static int parse(String current) {
        String[] currentTime = current.split(":");
        return Integer.parseInt(currentTime[0]) * 60 + Integer.parseInt(currentTime[1]);
    }

    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35"));
    }
}
