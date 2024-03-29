package com.nyu.datastructure.list_linkedlist;

import com.nyu.datastructure.list_linkedlist.util.ListNode;

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/submissions/
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
