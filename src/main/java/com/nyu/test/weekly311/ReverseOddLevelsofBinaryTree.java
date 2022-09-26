package com.nyu.test.weekly311;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ReverseOddLevelsofBinaryTree {

    public class TreeNode {
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

    public TreeNode bfs(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            // System.out.println("level:"+level);
            Deque<TreeNode> thisLevel = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    thisLevel.offer(t.left);
                    thisLevel.offer(t.right);
                }
            }
            queue = new ArrayDeque<>(thisLevel);

            if (level % 2 != 0) {
                while (!thisLevel.isEmpty()) {
                    TreeNode t = thisLevel.poll();
                    t.left.val = queue.pollLast().val;
                    t.right.val = queue.pollLast().val;
                }
            }

        }
        return root;
    }

    public TreeNode dfs(TreeNode root) {
        reverse(root.left, root.right, true);
        return root;
    }

    void swap(TreeNode l, TreeNode r) {
        int t = l.val;
        l.val = r.val;
        r.val = t;
    }

    void reverse(TreeNode l, TreeNode r, boolean flag) {
        if (l == null) return;
        if (flag) swap(l, r);//left.val ^= right.val ^ (right.val = left.val);
        reverse(l.left, r.right, !flag);
        reverse(l.right, r.left, !flag);
    }

}
