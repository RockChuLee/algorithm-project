package com.nyu.datastructure.queue_stack.util;

public class Test {
    public static void main(String[] args) {
        MyQueueByArray myQueue = new MyQueueByArray();
        myQueue.EnQueue(myQueue, 1);
        myQueue.EnQueue(myQueue, 2);
        myQueue.EnQueue(myQueue, 3);
        myQueue.EnQueue(myQueue, 4);
        System.out.println(myQueue.QueueLength(myQueue));
        myQueue.DeQueue(myQueue, 1);
        System.out.println(myQueue.QueueLength(myQueue));

        MyStackByArray s1 = new MyStackByArray();
        s1.Push(s1, 1);
        s1.Push(s1, 2);
        s1.Push(s1, 3);
        s1.Pop(s1, 0);
        System.out.println(s1.returnValue);
        s1.Pop(s1, 0);
        System.out.println(s1.returnValue);
        s1.Push(s1, 4);
    }
}
