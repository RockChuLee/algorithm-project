package com.nyu.datastructure.queue_stack.util;

public class MyQueueByLinkedlist {
    public static final int MAXSIZE = 200;
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public ListNode front;
    public ListNode rear;
    public ListNode node;
    public int returnValue;

    public MyQueueByLinkedlist() {
        this.node = new ListNode(-1);
        this.front = node;
        this.rear = node;
    }

    // 初始化操作，建立一个空队列Q。
    public int InitQueue(MyQueueByLinkedlist myQueue) {
        return OK;
    }

    //若队列Q存在，则销毁它。
    public int DestroyQueue(MyQueueByLinkedlist myQueue) {
        return OK;
    }

    //将队列Q清空。
    public int clearQueue(MyQueueByLinkedlist myQueue) {
        return OK;
    }

    //若队列Q为空，返回true，否则返回false。
    public int QueueEmpty(MyQueueByLinkedlist myQueue) {
        return OK;
    }

    //若队列Q存在且非空，用e返回队列的队头元素。
    public int GetHead(MyQueueByLinkedlist myQueue, int e) {
        return OK;
    }

    //若队列Q存在，插入新元素e到队列中并成为队尾元
    public int EnQueue(MyQueueByLinkedlist myQueue, int e) {
        // 分配一个新的 Node 并赋值
        ListNode s = new ListNode();
        s.val = e;
        s.next = null;
        // 把拥有元素e的新节点s赋值给原队尾结点的后继
        rear.next = s;
        // 把当前的s设置为队尾结点，rear指向s
        rear = s;
        return OK;
    }

    //删除队列Q中队头元素,并用e返回其值。
    public int DeQueue(MyQueueByLinkedlist myQueue, int e) {
        if (front == rear) {
            return ERROR;
        }
        // 将欲删除的队头结点暂存给p
        ListNode p = front.next;
        // 将欲删除的队头结点的值赋值给e
        e = p.val;
        returnValue = e;
        // 将原队头结点后继p.next 赋值给头结点后继
        front.next = p.next;
        // 若队头时队尾，则删除后将rear指向头结点
        if (rear == p) {
            rear = front;
        }
        return OK;
    }

    //返回队列Q的元素个数
    public int QueueLength(MyQueueByLinkedlist myQueue) {
        return OK;
    }

}