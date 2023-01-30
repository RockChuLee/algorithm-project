package com.nyu.datastructure.array.util;

public class MyArray {
    public static final int MAXSIZE = 200;
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    private int length;
    private int[] arr;
    public int returnValue;

    public MyArray() {
        this.length = 0;
        this.arr = new int[MAXSIZE];
    }

    // 获得元素操作
    // 时间复杂度 O(1)
    public int GetElem(MyArray L, int i, int e) {
        if (L.length == 0 || i < 1 || i > L.length) {
            return ERROR;
        }
        e = L.arr[i - 1];
        returnValue = e;
        return OK;
    }

    // 插入操作
    // 时间复杂度 O(n)
    public int ListInsert(MyArray L, int i, int e) {
        int k;
        if (L.length == MAXSIZE) {
            return ERROR;
        }
        if (i < 1 || i > L.length + 1) {
            return ERROR;
        }
        if (i <= L.length) {
            for (k = L.length - 1; k >= i - 1; k--) {
                L.arr[k + 1] = L.arr[k];
            }
        }
        L.arr[i - 1] = e;
        L.length++;
        return OK;
    }

    // 插入操作
    // 时间复杂度 O(n)
    public int ListDelete(MyArray L, int i, int e) {
        int k;
        if (L.length == 0) {
            return ERROR;
        }
        if (i < 1 || i > L.length + 1) {
            return ERROR;
        }
        e = L.arr[i - 1];
        returnValue = e;
        if (i < L.length) {
            for (k = i; k < L.length; k++) {
                L.arr[k - 1] = L.arr[k];
            }
        }
        L.arr[L.length - 1] = 0;
        L.length--;
        return OK;
    }
}
