package com.nyu.oa.tiktok2;

// https://leetcode.com/discuss/interview-question/1263982/Thomson-Reuters-or-OA-or-Circular-Printer
public class CircularPrinter {
    public static void main(String[] args) {
        String printer = "ZNMD";
        extracted(printer);
    }

    private static void extracted(String printer) {
        int[] arr = new int[25];
        int ptr = 0;
        int cost = 0;
        for (Character c : printer.toCharArray()) {
            int dest = c - 'A';
            int cw = ptr > dest ? (dest + 26 - ptr) : dest - ptr;
            int acw = ptr < dest ? (ptr + 26 - dest) : ptr - dest;
            cost += Math.min(cw, acw);
            ptr = dest;
        }
        System.out.println(cost);
    }
}
