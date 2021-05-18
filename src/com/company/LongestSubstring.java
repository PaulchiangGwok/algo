package com.company;

import java.util.*;

//https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstring {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    public int longestSubstring(String s, int k) {
        // 统计能由多少个字母组合而成
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0;
            int r = 0;
            int[] cnt = new int[26];
            // 当前总共的字符类型数量
            int tot = 0;
            // 没达到要求的数量
            int less = 0;

            while (r < n) {
                int pos = s.charAt(r) - 'a';
                cnt[pos]++;
                if (cnt[pos] == 1) {
                    tot++;
                    less++;
                }

                if (cnt[pos] == k) {
                    less--;
                }

                // 左移
                while (tot > t) {
                    int lpos = s.charAt(l) - 'a';
                    cnt[lpos]--;

                    if (cnt[lpos] == k - 1) {
                        less++;
                    }

                    if (cnt[lpos] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }

                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
