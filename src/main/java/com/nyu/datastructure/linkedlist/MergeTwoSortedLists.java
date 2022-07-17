package com.nyu.datastructure.linkedlist;

import com.nyu.datastructure.linkedlist.util.ListNode;

// https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
public class MergeTwoSortedLists {

    // recursion
    // Time Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    // Space Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // iteration
    // Time Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    // Space Complexity : O(1)，我们只需要常数的空间存放若干变量
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}

