package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(-1);
        List<Integer> l2 = Arrays.asList(-2, -3);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);
        input.add(l1);
        input.add(l2);
        //input.add(l3);
        //input.add(l4);

        System.out.println(minimumTotal(input));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] cost = initArray(triangle.size());

        //init

        cost[0] = triangle.get(0).get(0);

        boolean mark = true;
        for (List<Integer> level : triangle) {
            if (mark) {
                mark = false;
                continue;
            }
            int[] tempcost = initArray(triangle.size());
            for (int i = 0; i < cost.length; i++) {
                if (cost[i] == Integer.MAX_VALUE) {
                    break;
                }
                int l = cost[i] + level.get(i);
                int r = cost[i] + level.get(i + 1);

                tempcost[i] = Integer.min(tempcost[i], l);
                //这里按题目的数据是不会越界的
                tempcost[i + 1] = Integer.min(tempcost[i + 1], r);
            }
            cost = tempcost;
        }

        int res = Integer.MAX_VALUE;
        for (int i : cost) {
            res = Integer.min(res, i);
        }
        return res;
    }

    private static int[] initArray(int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        return res;
    }
}
