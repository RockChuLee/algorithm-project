package com.nyu.oa.tiktok3;

import java.util.Arrays;

public class BoringArray {
    public static boolean transformArray(String A, String B) {
        int N = 2000000;
        int[] arr = new int[2 * N + 2];

        String[] Astr = A.split(" ");
        String[] Bstr = B.split(" ");
        for (String s : Astr) {
            arr[N + Integer.parseInt(s)]++;
        }
        for (String s : Bstr) {
            int offset = N + Integer.parseInt(s);
            if (arr[offset] > 0) {
                arr[offset]--;
            } else if (offset - 1 >= 0 && arr[offset - 1] > 0) {
                arr[offset - 1]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean transformArray1(String A, String B) {
        String[] Astr = A.split(" ");
        int[] As = new int[Astr.length];
        for (int i = 0; i < Astr.length; i++) {
            As[i] = Integer.parseInt(Astr[i]);
        }
        Arrays.sort(As);
        String[] Bstr = B.split(" ");
        int[] Bs = new int[Astr.length];
        for (int i = 0; i < Bstr.length; i++) {
            Bs[i] = Integer.parseInt(Bstr[i]);
        }
        Arrays.sort(Bs);
        for (int i = 0; i < As.length; i++) {
            if (As[i] != Bs[i] && Bs[i] - As[i] != 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(transformArray1("-10 2 3 4 9", "-10 2 3 4 10"));
    }
}
