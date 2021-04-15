package com.company;

import java.util.*;
//https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
public class MinDiffInBST {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;

        System.out.println("Hello Worlds");
    }

    public int minDiffInBST(TreeNode root) {
        return dfs(root,Integer.MAX_VALUE);
    }

    public int dfs(TreeNode root,int value){
        int gap = value;
        if(root.left != null){
           int left = dfs(root.left,Math.abs(root.val- root.left.val));
           if(left < gap){
               gap = left;
           }
        } 

        if(root.right != null){
            int right = dfs(root.right,Math.abs(root.val- root.right.val));
            if(right < gap){
                gap = right;
            }
        }
        
        return gap;
    }

    class TreeNode {
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
}

