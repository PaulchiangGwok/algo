package com.company;

import java.util.ArrayList;
import java.util.List;

public class RemoveLeafNodes {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        //String input = "TO BE OR NOT TO BE";

        RemoveLeafNodes object = new RemoveLeafNodes();
        //Object res = object.removeLeafNodes();

        System.out.println();
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        boolean mark = judge(root, target);
        if(mark){
            root = null;
        }
        return root;
    }

    private boolean judge(TreeNode node,int target){
        if(node.left != null){
            if(judge(node.left,target)){
                node.left = null;
            }
        }

        if(node.right!= null){
            if(judge(node.right,target)){
                node.right = null;
            }
        }

        if(node.left == null && node.right == null){
            return target == node.val;
        } else {
            return false;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

