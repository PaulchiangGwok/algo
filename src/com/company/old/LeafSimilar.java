package com.company.old;

import java.util.*;

public class LeafSimilar {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(2)) {
                return false;
            }
        }

        return true;
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        if (node.left != null) {
            dfs(node.left, list);
        }

        if (node.right != null) {
            dfs(node.right, list);
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
