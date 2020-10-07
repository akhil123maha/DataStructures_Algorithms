package com.ds.algo.facebook.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public String serialize(TreeNode root) {
        if(root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        ArrayDeque<String> queue = new ArrayDeque(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(ArrayDeque<String> queue) {
        String string = queue.poll();
        if(string.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(string));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
