package com.nyu.datastructure.linkedlist.util;

import com.nyu.datastructure.linkedlist.LinkedListCycle;
import com.nyu.datastructure.linkedlist.RemoveDuplicatesfromSortedList2;
import com.nyu.datastructure.linkedlist.ReverseLinkedList;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static LinkedListCycle linkedListCycle = new LinkedListCycle();
    public static ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    public static RemoveDuplicatesfromSortedList2 removeDuplicatesfromSortedList2 = new RemoveDuplicatesfromSortedList2();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,3,4,4,5);
        ListNode head = initListNode(list);

        ListNode listNode = removeDuplicatesfromSortedList2.deleteDuplicates(head);

        System.out.println(toListNodeString(listNode));
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
