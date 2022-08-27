package com.nyu.oa.sig;

import java.util.HashMap;
import java.util.Map;

public class EnhancedHashMap {
    private static final Map<Integer, Integer> actualMap = new HashMap<>();
    private static int keyOffset = 0;
    private static int valueOffset = 0;

    public static boolean containsKey(int key) {
        int keyWithoutOffset = key - keyOffset;
        return actualMap.containsKey(keyWithoutOffset);
    }

    public static  boolean containsValue(int value) {
        int valueWithoutOffset = value - valueOffset;
        return actualMap.containsValue(valueWithoutOffset);
    }

    public static Integer get(int key) {
        int keyWithoutOffset = key - keyOffset;
        int value = actualMap.get(keyWithoutOffset);
        if (value == 0) return null;
        return value + valueOffset;
    }

    public static void put(int key, int value) {
        int keyWithoutOffset = key - keyOffset;
        int valueWithoutOffset = value - valueOffset;
        actualMap.put(keyWithoutOffset, valueWithoutOffset);

    }


    public static void addToValues(int toAdd) {
        valueOffset += toAdd;
    }

    public static void addToKeys(int toAdd) {
        keyOffset += toAdd;
    }

    public static void main(String[] args) {
        put(1, 2);
        addToValues(2);
        System.out.println(get(1));
        put(2, 3);
        addToKeys(1);
        addToValues(-1);
        System.out.println(get(3));


    }
}
