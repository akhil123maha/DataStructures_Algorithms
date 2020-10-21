package com.ds.algo.facebook.leetcode;

public class RangeSumBST {

    private int ans;

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

    public int rangeSumBST(TreeNode root,int L, int R){
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode root,int L, int R){
        if(root != null){
            if(root.val >= L && root.val <= R)
                ans = ans + root.val;
            if(root.val > L)
                dfs(root.left, L, R);
            if(root.val < R)
                dfs(root.right, L, R);
        }
    }



}
