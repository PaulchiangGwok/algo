package com.company.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 */
public class RemovePalindromeSub {
    public static void main(String[] args) {
    //
    //    System.out.println(removePalindromeSub(""));
    //}

        System.out.println(removePalindromeSub("abb"));
    }

    public static int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return 2;
                }
            }
            return 1;
        }
    }
}
