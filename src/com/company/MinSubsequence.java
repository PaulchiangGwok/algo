package com.company;

import java.util.*;

public class MinSubsequence {

    public static void main(String[] args) {
        //int[][] x = {{6, 6}, {3, 4}, {22, 26}, {29, 32}, {8, 10}, {8, 9}, {30, 30}, {19, 21}, {30, 34}, {20, 20},
        //    {29, 32}, {4, 5}, {16, 17}, {3, 3}, {14, 16}, {9, 10}, {2, 5}, {7, 11}, {3, 3}, {18, 20}, {26, 28},
        //    {15, 19}, {26, 27}, {22, 22}, {2, 3}, {16, 20}, {2, 3}, {23, 27}, {25, 28}, {17, 20}};
        int[] num = {6};
        System.out.println(minSubsequence(num));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int t = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int handle = nums[i];
            res.add(handle);
            t += handle;

            if (t > sum - t) {
                break;
            }
        }

        return res;
    }
}
