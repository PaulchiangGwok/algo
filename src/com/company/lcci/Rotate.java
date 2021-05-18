package com.company.lcci;

import java.util.*;

public class Rotate {

    // 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
    // 说明：解集不能包含重复的子集。
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3 };
        // int[][] arr = { 5, 2, 3 };
        // int target = 10;
        rotate(null);
        // System.out.println(rotate(null));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

         // 主对角线翻转
         for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
