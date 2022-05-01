package com.nyu.test;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        dfs(root1, heap);
        dfs(root2, heap);

        while (heap.peek()!=null) {
            result.add(heap.poll());
        }

        return result;
    }

    private void dfs(TreeNode root, PriorityQueue<Integer> heap) {
        if (root != null) {
            heap.offer(root.val);
        }else {
            return;
        }
        if (root.left != null) {
            dfs(root.left, heap);

        }
        if (root.right != null) {
            dfs(root.right, heap);

        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(3);
        heap.offer(1);
        heap.offer(2);
        heap.offer(6);
        heap.offer(4);
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}