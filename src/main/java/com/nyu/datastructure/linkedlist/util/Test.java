package com.nyu.datastructure.linkedlist.util;

import com.nyu.datastructure.linkedlist.LinkedListCycle;
import com.nyu.datastructure.linkedlist.ReverseLinkedList;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static LinkedListCycle linkedListCycle = new LinkedListCycle();
    public static ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 0, -4);
        ListNode head = initListNode(list);

        System.out.println(reverseLinkedList.reverseList(head));
    }

    private static ListNode initListNode(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        for (int i = 0; i < list.size(); i++) {
            ListNode temp = new ListNode(list.get(i),null);
            head.next = temp;
            head = temp;
        }
        return dummy;
    }
}