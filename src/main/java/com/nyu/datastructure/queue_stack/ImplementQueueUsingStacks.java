package com.nyu.datastructure.queue_stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void enqueue(int x) {
        if (stack1.isEmpty())
            front = x;
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
