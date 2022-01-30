package com.nyu.datastructure.linkedlist;

//https://leetcode-cn.com/problems/reverse-linked-list/
public class ReverseLinkedList {

    //recursion
    // Time Complexity :
    // Space Complexity :
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    //iterator
    // Time Complexity :
    // Space Complexity :
    public ListNode reverseList1(ListNode head) {
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
