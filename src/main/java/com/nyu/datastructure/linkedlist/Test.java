package com.nyu.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static LinkedListCycle linkedListCycle = new LinkedListCycle();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 0, -4);
        ListNode head = initListNode(list);

        System.out.println(linkedListCycle.hasCycle(head));
    }

    private static ListNode initListNode(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 1; i < list.size(); i++) {
            temp.next.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }
}
