package com.nyu.test.weekly8;


import java.util.ArrayList;
import java.util.HashMap;

public class AverageOfSubtree {

    int result = 0;
    int sum = 0;
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            result++;
            return;
        }
        if (isValid(root)) {
            result++;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public boolean isValid(TreeNode root) {
        sum = 0;
        count = 0;
        calculate(root);
        System.out.println(sum);
        System.out.println(count);
        return sum / count == root.val;
    }

    public void calculate(TreeNode root) {
        sum += root.val;
        count++;
        if (root.left == null && root.right == null) {
            sum += root.val;
            count++;
            return;
        }
        if (root.left != null) {
            calculate(root.left);
        }
        if (root.right != null) {
            calculate(root.right);
        }
    }

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
}
