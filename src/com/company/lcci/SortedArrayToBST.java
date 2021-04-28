package com.company.lcci;

import java.util.*;

public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] arr = { -10,-3,0,5,9 };
        // int target = 10;
        SortedArrayToBST obj = new SortedArrayToBST();
        System.out.println(obj.sortedArrayToBST(arr));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        return buildNode(list);
    }

    public TreeNode buildNode(List<Integer> list) {
        if (list == null ||list.size() == 0){
            return null;
        }
        if (list.size() == 1) {
            return new TreeNode(list.get(0));
        }
        int mid = list.size() / 2;
        TreeNode current = new TreeNode(list.get(mid));
        current.left = buildNode(list.subList(0, mid));
        current.right = buildNode(list.subList(mid + 1, list.size()));
        return current;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
