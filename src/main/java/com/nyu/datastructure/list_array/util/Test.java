package com.nyu.datastructure.list_array.util;

public class Test {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.ListInsert(myArray, 1, 1);
        myArray.ListInsert(myArray, 1, 2);
        myArray.ListInsert(myArray, 1, 3);
        myArray.ListInsert(myArray, 1, 4);
        myArray.ListInsert(myArray, 1, 5);
        myArray.GetElem(myArray, 1, 0);
        System.out.println(myArray.returnValue);
        myArray.ListDelete(myArray, 3, 0);
        System.out.println(myArray.returnValue);
    }
}
