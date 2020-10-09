package com.ds.algo.facebook.leetcode;

public class DiameterOfBinaryTree {

    private int ans;

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

    public int diameterOfBinaryTree(TreeNode root) {
        int ans = 1;
        height(root);
        return ans-1;
    }

    private int height(TreeNode root) {
        if(root == null)
            return 0;
        int L = height(root.left);
        int R = height(root.right);
        ans = Math.max(ans, L+R+1);
        return 1 + Math.max(L,R);
    }
}
