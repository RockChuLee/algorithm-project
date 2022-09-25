package com.nyu.util.myutli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyConvert {
    public static void main(String[] args) {
//        System.out.println(convertCharArray2String(convertString2CharArray("dafadjfka")));
        System.out.println(String.valueOf(new char[]{'1','2','3'}));
    }

    public static List<Integer> convertStandardArray2ArrayList(Integer[] stanArrs) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> you = Arrays.stream(data).boxed().collect(Collectors.toList());
        List<Integer> like = IntStream.of(data).boxed().collect(Collectors.toList());

        return Arrays.asList(stanArrs);
    }

    public static Integer[] convertArrayList2StandardArray(ArrayList<Integer> arrs) {

        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer[] what = Arrays.stream(data).boxed().toArray(Integer[]::new);
        Integer[] ever = IntStream.of(data).boxed().toArray(Integer[]::new);

        Integer[] stanArrs = new Integer[arrs.size()];
        arrs.toArray(stanArrs);
        return stanArrs;
    }

    public static String convertCharArray2String(char[] charArray) {
        return String.valueOf(charArray);
    }

    public static char[] convertString2CharArray(String string) {
        return string.toCharArray();
    }
}
