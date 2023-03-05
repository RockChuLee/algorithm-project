package com.nyu.datastructure.queue_stack.util;

public class MyQueueByArray {
    public static final int MAXSIZE = 200;
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public int front;
    public int rear;
    public int[] arr;
    public int returnValue;

    public MyQueueByArray() {
        front = 0;
        rear = 0;
        this.arr = new int[MAXSIZE];
    }

    // 初始化操作，建立一个空队列Q。
    public int InitQueue(MyQueueByArray myQueue) {
        return OK;
    }

    //若队列Q存在，则销毁它。
    public int DestroyQueue(MyQueueByArray myQueue) {
        return OK;
    }

    //将队列Q清空。
    public int clearQueue(MyQueueByArray myQueue) {
        return OK;
    }

    //若队列Q为空，返回true，否则返回false。
    public int QueueEmpty(MyQueueByArray myQueue) {
        return OK;
    }

    //若队列Q存在且非空，用e返回队列的队头元素。
    public int GetHead(MyQueueByArray myQueue, int e) {
        return OK;
    }

    //若队列Q存在，插入新元素e到队列中并成为队尾元
    public int EnQueue(MyQueueByArray myQueue, int e) {
        // 队列满的判断
        if ((rear + 1) % MAXSIZE == front) {
            return ERROR;
        }
        // 将元素e赋值给队尾
        arr[rear] = e;
        // rear指针向后移一位置，若到最后则转到数组头部
        rear = (myQueue.rear + 1) % MAXSIZE;
        return OK;
    }

    //删除队列Q中队头元素,并用e返回其值。
    public int DeQueue(MyQueueByArray myQueue, int e) {
        // 队列空的判断
        if (rear == front) {
            return ERROR;
        }
        // 将队头元素赋值给e
        e = arr[front];
        returnValue = e;
        // front指针向后移一位置，若到最后则转到数组头部
        front = (front + 1) % MAXSIZE;
        return OK;
    }

    //返回队列Q的元素个数
    public int QueueLength(MyQueueByArray myQueue) {
        return (rear - front + MAXSIZE) % MAXSIZE;
    }

}