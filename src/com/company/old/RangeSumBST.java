package com.company.old;

import java.util.*;

public class RangeSumBST {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return scan(root,low,high,0);
    }

    public int scan(TreeNode node, int low, int high, int sum) {
        // 先处理剪枝
        if (node.val < low) {
            if (node.right != null) {
                sum = scan(node.right, low, high, sum);
            }
            return sum;
        } else if (node.val > high) {
            if (node.left != null) {
                sum = scan(node.left, low, high, sum);
            }
            return sum;
        } else {
            sum += node.val;
            if(node.left!=null){
                sum = scan(node.left,low,high,sum);
            }
            if(node.right != null){
                sum = scan(node.right,low,high,sum);
            }
            return sum;
        }
    }

    class TreeNode {
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

}
