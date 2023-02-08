package com.nyu.datastructure.list_linkedlist;

import com.nyu.datastructure.list_linkedlist.util.ListNode;

// https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList(ListNode head) {
        // handle special situation
        if (head == null) return;

        // two point to find mid of linklist
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the last part of linklist
        ListNode curr = slow;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode l1 = head;
        ListNode l2 = prev;

        // merge just like fried dough twist
        while(l2.next!=null){
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = temp;

            temp = l2.next;
            l2.next = l1;
            l2 = temp;
        }
    }
}
