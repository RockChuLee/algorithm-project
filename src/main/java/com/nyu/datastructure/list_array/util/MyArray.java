package com.nyu.datastructure.list_array.util;

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

    // 获得元素操作：将线性表L中的第i个位置元素值返回给e。
    // 时间复杂度 O(1)
    // 空间复杂度 O(1)
    public int GetElem(MyArray L, int i, int e) {
        if (L.length == 0 || i < 1 || i > L.length) {
            return ERROR;
        }
        e = L.arr[i - 1];
        returnValue = e;
        return OK;
    }

    // 插入操作：在线性表L中第i个位置插入新元素e。
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int ListInsert(MyArray L, int i, int e) {
        int k;
        // 如果插入位置不合理，抛出异常
        if (L.length == MAXSIZE) {
            return ERROR;
        }
        // 如果线性表长度大于等于数组长度，则抛出异常或动态增加容量
        if (i < 1 || i > L.length + 1) {
            return ERROR;
        }
        // 如果插入位置不在末尾
        if (i <= L.length) {
            // 从最后一个元素开始向前遍历到第i个位置，分别将它们都向后移动一个位置
            for (k = L.length - 1; k >= i - 1; k--) {
                L.arr[k + 1] = L.arr[k];
            }
        }
        // 将要插入的元素填入位置i处
        L.arr[i - 1] = e;
        // 表长加一
        L.length++;
        // 返回状态
        return OK;
    }

    // 删除操作：删除线性表L中第i个位置元素，并用e返回其值。
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int ListDelete(MyArray L, int i, int e) {
        int k;
        // 如果删除位置不合理，抛出异常
        if (L.length == 0) {
            return ERROR;
        }
        if (i < 1 || i > L.length + 1) {
            return ERROR;
        }
        // 取出删除元素
        e = L.arr[i - 1];
        returnValue = e;
        // 如果删除的元素不在末尾
        if (i < L.length) {
            // 从删除元素位置开始遍历到最后一个元素位置，分别将它们都向前移动一个位置
            for (k = i; k < L.length; k++) {
                L.arr[k - 1] = L.arr[k];
            }
        }
        // 最后一个元素的位置置0
        L.arr[L.length - 1] = 0;
        // 表长减一
        L.length--;
        // 返回状态
        return OK;
    }


    //初始化操作,建立一个空的线性表L。
    public int InitList(MyArray L, int[] nums) {
        //TODO
        return OK;
    }

    //判断线性表是否为空表，若线性表为空，返回true,否则返回false。
    public int ListEmpty(MyArray L) {
        //TODO
        return TRUE;
    }

    //将线性表清空。
    public int ClearList(MyArray L) {
        //TODO
        return OK;
    }

    //在线性表L中查找与给定值e相等的元素，如果查找成功，返回该元素在表中序号表示成功。;否则，返回0表示失败。
    public int LocateElem(MyArray L, int e) {
        //TODO
        return OK;
    }

    //返回线性表L的元素个数。
    public int ListLength(MyArray L) {
        //TODO
        return L.length;
    }
}
