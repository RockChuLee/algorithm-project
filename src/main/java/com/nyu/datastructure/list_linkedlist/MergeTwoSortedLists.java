package com.nyu.datastructure.list_linkedlist;

import com.nyu.datastructure.list_linkedlist.util.ListNode;

// https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
public class MergeTwoSortedLists {

    // recursion
    // Time Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    // Space Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // iteration
    // Time Complexity : O(n+m)，其中 n 和 m 分别为两个链表的长度
    // Space Complexity : O(1)，我们只需要常数的空间存放若干变量
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);

        ListNode head = prev;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        // 合并后 list1 和 list2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        head.next = list1 == null ? list2 : list1;

        return prev.next;
    }
}

