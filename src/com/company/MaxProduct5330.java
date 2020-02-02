package com.company;

import java.math.BigInteger;
import java.util.*;

public class MaxProduct5330 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        //String num = "/../";
        //System.out.print(simplifyPath(num));
        MaxProduct5330 KWeakestRows = new MaxProduct5330();
        //int[][] input = {{1, 1, 0, 0, 0},
        //    {1, 1, 1, 1, 0},
        //    {1, 0, 0, 0, 0},
        //    {1, 1, 0, 0, 0},
        //    {1, 1, 1, 1, 1}};
        //int k = 3;
        //int[] input = {1000, 1000, 3, 7};
        //Object res =
        //    KWeakestRows.maxProduct(input);
        //System.out.println();
    }

    public int maxProduct(TreeNode root) {
        int MODULO = 1000000007;
        //遍历整个树求sum
        HashSet<Integer> sumCache = new HashSet<>();
        int total = getSum(root, sumCache);
        //求面积

        List<Integer> list = new ArrayList<>(sumCache);
        long max = 0;
        for (int i : list) {
            long product = (long) i * (long) (total - i);
            max = Math.max(max,product);
        }
        return (int) (max % MODULO);//1_000_000_007
    }

    private int getSum(TreeNode node, HashSet<Integer> sumCache) {
        int sum = node.val;
        if (node.left != null) {
            sum += getSum(node.left, sumCache);
        }

        if (node.right != null) {
            sum += getSum(node.right, sumCache);
        }
        sumCache.add(sum);
        return sum;
    }

}
