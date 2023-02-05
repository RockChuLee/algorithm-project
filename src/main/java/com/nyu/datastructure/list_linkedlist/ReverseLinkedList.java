package com.nyu.datastructure.list_linkedlist;

import com.nyu.datastructure.list_linkedlist.util.ListNode;

//https://leetcode-cn.com/problems/reverse-linked-list/
public class ReverseLinkedList {

    // Recursion
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // Iterator
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public ListNode iterator(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
