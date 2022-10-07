package com.nyu.oa.tiktok3;

import java.util.Arrays;

public class BoringArray {
    public static boolean transformArray(String a, String b) {
        // Write your code here
        String[] Astr = a.split(" ");
        int[] As = new int[Astr.length];
        for (int i = 0; i < Astr.length; i++) {
            As[i] = Integer.parseInt(Astr[i]);
        }
        Arrays.sort(As);
        String[] Bstr = b.split(" ");
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
        System.out.println(transformArray("4 3 2 1 0", "1 2 3 4 5"));
    }
}
