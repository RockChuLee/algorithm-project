package com.nyu.datastructure.tree;

import com.nyu.datastructure.tree.util.TreeNode;

//https://leetcode.cn/problems/maximum-depth-of-binary-tree/
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
