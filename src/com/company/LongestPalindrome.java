package com.company;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cc"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return String.valueOf(s.charAt(0));
            }
        }

        String res = "";
        //边界的两个不需要判断
        for (int i = 0; i < s.length() - 1; i++) {
            //先判断是中心对称还是轴对称
            String tmp;
            if (s.charAt(i) == s.charAt(i + 1)) {
                //中心对称
                tmp = check(s, i, i + 1);
            }
            //测试轴对称
            tmp = check(s, i, i);


            if (tmp.length() > res.length()) {
                res = tmp;
            }
        }
        return res;
    }

    public static String check(String s, int start, int end) {
        while (start > 0 && end < s.length() - 1) {
            if (s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        return s.substring(start, end + 1);
    }
}
