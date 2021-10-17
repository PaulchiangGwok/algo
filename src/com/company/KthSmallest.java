package com.company;

public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        return -dfs(root,k);
    }

    public static int dfs(TreeNode root, int k){
        if(root.left != null){
            k = dfs(root,k);

            if(k < 0){
                return k;
            }
        }
        k--;
        if(k == 0){
            //这里是结果
            return -root.val;
        }

        if(root.right != null){
           k = dfs(root,k);
           if(k < 0){
               return k;
           }
        }

        return k;
    }

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
}
