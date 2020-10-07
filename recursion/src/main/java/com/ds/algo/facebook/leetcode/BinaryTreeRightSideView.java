package com.ds.algo.facebook.leetcode;

import java.util.*;

public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> outputList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode currentElement = queue.poll();
                if(i == level-1)
                    outputList.add(currentElement.val);
                if(currentElement.left != null)
                    queue.offer(currentElement.left);
                if(currentElement.right != null)
                    queue.offer(currentElement.right);
            }
        }
        return outputList;
    }
}
