package com.company.old;

import java.util.*;

public class NumWays {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;
        System.out.println("Hello Worlds");
    }

    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);

        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                // 不动的
                dp[i][j] = dp[i - 1][j];
                // 向右移动
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                // 向左移动
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }
}
