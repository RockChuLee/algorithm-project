package com.nyu.datastructure.list_linkedlist;

import com.nyu.datastructure.list_linkedlist.util.ListNode;

//https://leetcode-cn.com/problems/remove-linked-list-elements/solution/
public class RemoveLinkedListElements {

    //recursion
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    //iterator
    // Time Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    // Space Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;

    }


}
