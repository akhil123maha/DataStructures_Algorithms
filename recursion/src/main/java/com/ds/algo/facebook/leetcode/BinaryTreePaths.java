package com.ds.algo.facebook.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePaths {

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

    public List<String> binaryTreePaths(TreeNode root){
        List<String> output = new ArrayList<>();
        if(root == null)
            return output;
        return binaryTreePathsHelper(root, output, String.valueOf(root.val));
    }

    public List<String> binaryTreePathsHelper(TreeNode root, List<String> output, String path){
        if(root.left == null && root.right == null)
        {
            output.add(path);
            return output;
        }
        if(root.left != null)
            binaryTreePathsHelper(root.left, output, path+"->"+root.left.val);
        if(root.right != null)
            binaryTreePathsHelper(root.right, output, path+"->"+root.right.val);
        return output;
    }
}
