package com.nyu.oa.walmart;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/lru-cache/
public class LRUCache {

    private Map<Integer, DLLNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLLNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // move the accessed node to the head;
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLLNode node = cache.get(key);

        if (node == null) {
            ++size;

            if (size > capacity) {
                // pop the tail
                DLLNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
            DLLNode newNode = new DLLNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);


        } else {
            // update the value.
            node.value = value;
            updateNode(node);
        }
    }

    class DLLNode {
        int key;
        int value;
        DLLNode prev;
        DLLNode next;
    }

    private void addNode(DLLNode node) {
        /**
         * Always add the new node right after head.
         */
        DLLNode prevNode = head;
        DLLNode nextNode = head.next;
        node.next = nextNode;
        node.prev = prevNode;
        nextNode.prev = node;
        prevNode.next = node;
    }

    private void removeNode(DLLNode node) {
        /**
         * Remove an existing node from the linked list.
         */
        DLLNode prevNode = node.prev;
        DLLNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void updateNode(DLLNode node) {
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLLNode popTail() {
        /**
         * Pop the current tail.
         */
        DLLNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
