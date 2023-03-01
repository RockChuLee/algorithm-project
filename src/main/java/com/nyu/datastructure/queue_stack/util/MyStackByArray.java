package com.nyu.datastructure.queue_stack.util;

public class MyStackByArray {
    public static final int MAXSIZE = 200;
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public int top;
    public int[] arr;
    public int returnValue;

    public MyStackByArray() {
        this.top = -1;
        this.arr = new int[MAXSIZE];
    }

    // 初始化操作，建立一个空S。
    public int InitStack(MyStackByArray S) {
        return OK;
    }

    //若栈存在，则销毁它。
    public int DestroyStack(MyStackByArray S) {
        return OK;
    }

    //将栈清空。
    public int ClearStack(MyStackByArray S) {
        return OK;
    }

    //若栈为空，返回true，否则返回 false。
    public int StackEmpty(MyStackByArray S) {
        return OK;
    }

    //若栈存在且非空，用e返回S的栈顶元素。
    public int GetTop(MyStackByArray S, int e) {
        return OK;
    }

    //若栈S存在,插入新元素e到S中并成为栈顶元素。
    public int Push(MyStackByArray S, int e) {
        // 栈满
        if (top == MAXSIZE - 1) {
            return ERROR;
        }
        // 栈顶指针增加一
        top ++;
        // 将新插入的元素赋值得栈顶空间
        arr[top] = e;
        return OK;
    }


    //删除S中栈顶元素，并用e返回其值。
    public int Pop(MyStackByArray S, int e) {
        // 栈空
        if (top == - 1) {
            return ERROR;
        }
        // 将要删除的栈顶元素赋值给e
        e = arr[top];
        // 栈顶指针减一
        returnValue = e;
        top--;
        return OK;
    }

    //返回栈S的元素个数。
    public int StackLength(MyStackByArray s) {
        return OK;
    }

}
