package com.nyu.datastructure.linkedlist;

import com.nyu.datastructure.linkedlist.util.ListNode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/linked-list-cycle/
public class LinkedListCycle {

    // hashtable
    // Time Complexity : N
    // Space Complexity : N
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //slow-fast point
    // Time Complexity : N
    // Space Complexity : 1
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
