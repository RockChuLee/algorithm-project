package com.nyu.test.archive.weekly307;

import java.util.*;

public class AmountofTimeforBinaryTreetoBeInfected {

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

    HashMap<TreeNode, List<TreeNode>> graph;
    Set<TreeNode> visited;
    Queue<TreeNode> queue;
    TreeNode infected;

    public int amountOfTime(TreeNode root, int start) {
        graph = new HashMap();
        visited = new HashSet();
        queue = new ArrayDeque<TreeNode>();

        buildGraph(root, start);

        queue.offer(infected);
        visited.add(infected);

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();

                for (TreeNode neighbour : graph.get(current)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            minutes++;
        }

        return minutes - 1;
    }

    private void buildGraph(TreeNode root, int start) {
        if (root == null) return;

        if (!graph.containsKey(root))
            graph.put(root, new ArrayList<TreeNode>());

        if (root.left != null) {
            if (!graph.containsKey(root.left))
                graph.put(root.left, new ArrayList<TreeNode>());

            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
        }

        if (root.right != null) {
            if (!graph.containsKey(root.right))
                graph.put(root.right, new ArrayList<TreeNode>());

            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
        }

        if (root.val == start)
            infected = root;

        buildGraph(root.left, start);
        buildGraph(root.right, start);
    }
}
