package com.company;

import java.util.Arrays;

//https://leetcode-cn.com/problems/assign-cookies/
public class FindContentChildren {

    public static void main(String[] args) {
        int[] g = { 1, 2 };
        int[] s = { 1, 2, 3 };
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        int res = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int k = s.length - 1;
        int i = g.length - 1;
        for (; i >= 0; i--) {
            if (k < 0) {
                break;
            }
            // 从后往前扫 向下兼容 所以要先保证大的
            if (g[i] <= s[k]) {
                k--;
                res++;
            }
        }
        return res;
    }
}
