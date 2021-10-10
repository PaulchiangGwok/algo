package com.company.old;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    public static void main(String[] args) {
        //int[] input = {7, 1, 5, 3, 6, 4};
        //int[] input = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int input = 4;
        System.out.println(climbStairs(input));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        //int[] dp = new int[n];
        int l = 1;
        int r = 2;

        for (int i = 2; i < n; i++) {
            int t = l + r;
            l = r;
            r = t;
        }

        return r;
    }
}
