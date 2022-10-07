package com.nyu.oa.tiktok3;

public class BoringArray {
    public static boolean transformArray(String A, String B) {
        int N = 10;
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

    public static void main(String[] args) {
        System.out.println(transformArray("-10 2 3 4 9", "-10 2 3 4 10"));
    }
}
