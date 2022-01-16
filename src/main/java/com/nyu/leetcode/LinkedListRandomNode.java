package com.nyu.leetcode;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Random;

public class LinkedListRandomNode {

    public static ArrayList<Integer> linkedList = new ArrayList<>();

    public LinkedListRandomNode(ListNode head) {
        linkedList.add(head.val);
        while (head.next != null) {
            linkedList.add(head.next.val);
            head = head.next;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(linkedList.size());
        return linkedList.get(i);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,null);
        LinkedListRandomNode linkedListRandomNode = new LinkedListRandomNode(head);
        Random random = new Random();
        System.out.println(linkedList.size());
        int i = random.nextInt(linkedList.size());
        System.out.println(i);
    }

}
