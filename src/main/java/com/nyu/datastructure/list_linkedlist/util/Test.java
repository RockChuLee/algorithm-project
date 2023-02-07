package com.nyu.datastructure.list_linkedlist.util;

import com.nyu.datastructure.list_linkedlist.LinkedListCycle;
import com.nyu.datastructure.list_linkedlist.RemoveDuplicatesfromSortedList2;
import com.nyu.datastructure.list_linkedlist.ReverseLinkedList;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.ListInsert(myLinkedList, 1, 1);
        myLinkedList.ListInsert(myLinkedList, 2, 2);
        myLinkedList.ListInsert(myLinkedList, 3, 3);
        myLinkedList.ListInsert(myLinkedList, 4, 4);
        myLinkedList.ListInsert(myLinkedList, 5, 6);
        myLinkedList.ListInsert(myLinkedList, 6, 5);
        myLinkedList.GetElem(myLinkedList, 5, 0);
        System.out.println(myLinkedList.returnValue);
        myLinkedList.ListDelete(myLinkedList, 5, 0);
        System.out.println(myLinkedList.returnValue);
        myLinkedList.GetElem(myLinkedList, 5, 0);
        System.out.println(myLinkedList.returnValue);
    }
}
