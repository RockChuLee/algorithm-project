package com.nyu.datastructure.queue_stack.util;

public class MyStackByLinkedlist {
    public static final int MAXSIZE = 200;
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public ListNode top;
    public ListNode node;
    public int count;
    public int returnValue;

    public MyStackByLinkedlist() {
        this.node = new ListNode(-1);
        this.top = node;
        this.count = 0;
    }

    // 初始化操作，建立一个空S。
    public int InitStack(MyStackByLinkedlist S) {
        return OK;
    }

    //若栈存在，则销毁它。
    public int DestroyStack(MyStackByLinkedlist S) {
        return OK;
    }

    //将栈清空。
    public int ClearStack(MyStackByLinkedlist S) {
        return OK;
    }

    //若栈为空，返回true，否则返回 false。
    public int StackEmpty(MyStackByLinkedlist S) {
        if (count == 0) {
            return TRUE;
        }else {
            return FALSE;
        }
    }

    //若栈存在且非空，用e返回S的栈顶元素。
    public int GetTop(MyStackByLinkedlist S, int e) {
        return OK;
    }

    //若栈S存在,插入新元素e到S中并成为栈顶元素。
    public int Push(MyStackByLinkedlist S, int e) {
        // 开辟新的Node并赋值
        ListNode s = new ListNode();
        s.val = e;
        // 把当前的栈顶元素赋值给新结点的直接后继
        s.next = top;
        // 将新的结点 s 赋值给栈顶指针
        top = s;
        count++;
        return OK;
    }


    //删除S中栈顶元素，并用e返回其值。
    public int Pop(MyStackByLinkedlist S, int e) {
        ListNode p ;
        if (StackEmpty(S) == 1) {
            return ERROR;
        }
        e = top.val;
        // 将栈顶结点赋值给p
        p = top;
        // 使得栈顶指针下移一位，指向后一结点
        top = top.next;
        count--;
        return OK;
    }

    //返回栈S的元素个数。
    public int StackLength(MyStackByLinkedlist s) {
        return OK;
    }

}
