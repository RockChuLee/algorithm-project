package com.nyu.oa.csico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrintLength {
    public int readList() {
        int length = 0;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(""));
            String ln;
            while ((ln = in.readLine()) != null) {
                length += ln.split(" ").length;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return length;
    }

    public static int readList1() {
        Scanner in = new Scanner(System.in);
        // input for days
        String s = in.nextLine();
        return s.split(" ").length;
    }

    public static void main(String[] args) {
        System.out.println(readList1());
    }
}
