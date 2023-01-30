package com.nyu.datastructure.linkedlist.util;

public class MyLinkedList {
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    private int length;
    private ListNode node;
    public int returnValue;

    public MyLinkedList() {
        this.node = new ListNode();
    }

    // 单链表的读取
    // 时间复杂度 O(n)
    public int GetElem(MyLinkedList L, int i, int e) {
        int j;
        ListNode p = new ListNode();
        p = L.node.next;
        j = 1;
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }
        if (p == null || j > i) {
            return ERROR;
        }
        e = p.val;
        returnValue = e;
        return OK;
    }

    // 单链表的插入
    // 插入一个元素的时间复杂度是 O(n)，插入多个元素的时间复杂度，除第一个是 O(n) 外，其余都是 O(1)
    public int ListInsert(MyLinkedList L, int i, int e) {
        int j;
        ListNode p = L.node.next;
        ListNode s;
        j = 1;
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }
        if (p == null || j > i) {
            return ERROR;
        }
        s = new ListNode(e);
        s.next = p.next;
        p.next = s;
        return OK;
    }

    // 单链表的删除
    // 同插入
    public int ListDelete(MyLinkedList L, int i, int e) {
        int j;
        ListNode p = L.node.next;
        ListNode q;
        j = 1;
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }
        if (p.next == null || j > i) {
            return ERROR;
        }
        q = p.next;
        p.next = q.next;
        e = q.val;
        returnValue = e;
        q = null;
        return OK;
    }

    // 单链表的整表删除
    public int clearList(MyLinkedList L, int i, int e) {
        ListNode p = L.node.next;
        ListNode q;
        while (p != null) {
            q = p.next;
            p = null;
            p = q;
        }
        L.node.next = null;
        return OK;
    }
}
