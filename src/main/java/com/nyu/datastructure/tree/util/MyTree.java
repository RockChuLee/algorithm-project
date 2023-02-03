package com.nyu.datastructure.tree.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTree {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, null, null, 4, null, null, 5, null, null);
        List<Integer> newList = new ArrayList<>(list);
        TreeNode build = build(newList);
        List<Integer> parse = parse(build, new ArrayList<>());
        System.out.println(parse);
    }

    public static TreeNode build(List<Integer> list) {
        if (list.get(0) == null) {
            list.remove(0);
            return null;
        }
        Integer num = list.get(0);
        TreeNode node = new TreeNode(num);
        list.remove(0);
        node.left = build(list);
        node.right = build(list);
        return node;
    }

    public static List<Integer> parse(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(null);
        } else {
            list.add(node.val);
            parse(node.left, list);
            parse(node.right, list);
        }
        return list;
    }
}
