package com.nyu.datastructure.queue_stack.util;

public class MyStack {
    public static final int MAXSIZE = 200;
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    private int length;
    private int[] arr;
    public int returnValue;

    public MyStack() {
        this.length = 0;
        this.arr = new int[MAXSIZE];
    }

}
