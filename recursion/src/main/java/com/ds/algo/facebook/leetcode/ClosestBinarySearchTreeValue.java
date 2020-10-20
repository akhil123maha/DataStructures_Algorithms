package com.ds.algo.facebook.leetcode;

public class ClosestBinarySearchTreeValue {
    int goal;
    double min = Integer.MAX_VALUE;

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

    public int closestBinarySearchTreeValue(TreeNode root, double target){
        closestBinarySearchTreeValue(root, target);
        return goal;

    }
    private void closestBinarySearchTreeValueHelper(TreeNode root, double target) {
        if(root == null)
            return;
        double closest = Math.abs(root.val - target);
        if(closest < min){
            min = closest;
            goal = root.val;
        }
        if(root.val < target)
            closestBinarySearchTreeValueHelper(root.left, target);
        else
            closestBinarySearchTreeValueHelper(root.right, target);
    }
}
