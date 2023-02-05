package com.nyu.datastructure.list_linkedlist.util;

public class MyLinkedList {
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    private int length;
    private ListNode node;
    public int returnValue;
    //让构造函数为 private，这样该类就不会被实例化
    public MyLinkedList(){
        this.node = new ListNode(-1);
    }


    // 单链表的读取
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int GetElem(MyLinkedList L, int i, int e) {
        // 声明一个结点p指向链表的第一个结点
        ListNode p = L.node.next;
        // 初始化j从1开始
        int j = 1;
        // 当j<i时，就遍历链表，让p的指针向后移动，不断指向下一个结点，j累加1
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }
        // 若到链表末尾p为空，则说明第i个元素不存在
        if (p == null || j > i) {
            return ERROR;
        }
        // 否则查找成功，返回结点p的数据
        e = p.val;
        returnValue = e;
        return OK;
    }

    // 单链表的插入
    // 时间复杂度：插入一个元素的时间复杂度是 O(n)，插入多个元素的时间复杂度，除第一个是 O(n) 外，其余都是 O(1)
    // 空间复杂度 O(1)
    public int ListInsert(MyLinkedList L, int i, int e) {
        // 声明一个结点p指向链表的第一个结点
        ListNode p = L.node;
        // 初始化j从1开始
        int j = 1;
        // 当j<i时，就遍历链表，让p的指针向后移动，不断指向下一个结点，j累加1
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }
        // 若到链表末尾p为空，则说明第i个元素不存在
        if (p == null || j > i) {
            return ERROR;
        }
        // 否则查找成功，在系统中生成一个空结点s
        ListNode s = new ListNode();
        // 将数据元素e赋值给s.val
        s.val = e;
        // 单链表的插入标准语句 s.next = p.next; p.next = s;
        s.next = p.next;
        p.next = s;
        // 返回状态
        return OK;
    }

    // 单链表的删除
    // 时间复杂度：同插入操作
    // 空间复杂度 O(1)
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
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int ClearList(MyLinkedList L) {
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

    //初始化操作,建立一个空的线性表L。
    public int InitList(MyLinkedList L) {
        L = new MyLinkedList();
        return OK;
    }

    //判断线性表是否为空表，若线性表为空，返回true,否则返回false。
    public int ListEmpty(MyLinkedList L) {
        //TODO
        return TRUE;
    }

    //在线性表L中查找与给定值e相等的元素，如果查找成功，返回该元素在表中序号表示成功。;否则，返回0表示失败。
    public int LocateElem(MyLinkedList L, int e) {
        //TODO
        return OK;
    }

    //返回线性表L的元素个数。
    public int ListLength(MyLinkedList L) {
        //TODO
        return L.length;
    }
}
