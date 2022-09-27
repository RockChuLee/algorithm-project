package com.nyu.oa.jpmorgan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RadixMinusOneComplement {
    public static void main(String[] args) {

        int a = -4;
        String bitStr = Integer.toBinaryString(a).toString();
        System.out.println(bitStr);
//        List<Character> bitArr = bitStr.chars().mapToObj((i) -> (char) i).collect(Collectors.toList());
//        Collections.reverse(bitArr);
//
//        System.out.println(join);
//        System.out.println((byte) a);
//        System.out.println(~a);

    }
}
