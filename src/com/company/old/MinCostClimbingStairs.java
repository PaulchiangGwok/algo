package com.company.old;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        //int[] input = {7, 1, 5, 3, 6, 4};
        int[] input = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(input));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Integer.min(cost[0], cost[1]);
        }
        int[] mincost = new int[cost.length];
        //init
        mincost[0] = cost[0];
        mincost[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            mincost[i] = Integer.min(mincost[i - 1], mincost[i - 2]) + cost[i];
        }

        return Integer.min(mincost[cost.length - 1], mincost[cost.length - 2]);
    }
}
