package com.nyu.test.weekly335;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSuminaBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return 0L;
        }
        PriorityQueue<Long> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            heap.offer(sum);
        }
        if (heap.size() < k) return -1L;
        for (int i = 1; i < k; i++) {
            heap.poll();
        }
        return heap.peek();
    }
}

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