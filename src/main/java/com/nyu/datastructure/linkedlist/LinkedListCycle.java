package com.nyu.datastructure.linkedlist;

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
        if (head == null || head.next == null) {
            return false;
        }

        //快指针在慢指针的下一个点， 用while

//        ListNode slow = head;
//        ListNode fast = head;
//        do {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        } while (slow != fast);

        //快慢指针在同一个点，用do while
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public LinkedListCycle() {
    }
}
