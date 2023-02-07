package com.nyu.datastructure.list_linkedlist.util;

import com.nyu.datastructure.list_linkedlist.LinkedListCycle;
import com.nyu.datastructure.list_linkedlist.RemoveDuplicatesfromSortedList2;
import com.nyu.datastructure.list_linkedlist.ReverseLinkedList;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static LinkedListCycle linkedListCycle = new LinkedListCycle();
    public static ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    public static RemoveDuplicatesfromSortedList2 removeDuplicatesfromSortedList2 = new RemoveDuplicatesfromSortedList2();

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,3,4,4,5);
//        ListNode head = initListNode(list);
//
//        ListNode listNode = removeDuplicatesfromSortedList2.deleteDuplicates(head);
//
//        System.out.println(toListNodeString(listNode));
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

    // initial a linkedlist
    private static ListNode initListNode(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        for (int i = 0; i < list.size(); i++) {
            ListNode temp = new ListNode(list.get(i),null);
            head.next = temp;
            head = temp;
        }
        return dummy.next;
    }

    // print a linkedlist
    private static String toListNodeString(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head!= null) {
            stringBuilder.append(head.val).append("->");
            head = head.next;
        }
        return stringBuilder.substring(0,stringBuilder.length()-2);
    }

}
