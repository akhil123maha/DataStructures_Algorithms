package com.ds.algo.facebook.leetcode;

public class MaxDepthBinaryTree {
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

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root){
        if(root == null)
            return -1;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l,r);
    }
}
