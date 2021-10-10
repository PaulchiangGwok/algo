package com.company;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababd"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String res = "";
        //边界的两个不需要判断
        for (int i = 1; i < s.length() - 2; i++) {
            //先判断是中心对称还是轴对称
            if (s.charAt(i) == s.charAt(i + 1)) {
                //中心对称
                String tmp = check(s, i, i + 1);

                if(tmp.length() > res.length()){
                    res = tmp;
                }
            } else {
                //测试轴对称
                String tmp = check(s, i, i);

                if(tmp.length() > res.length()){
                    res = tmp;
                }
            }
        }
        return res;
    }

    public static String check(String s, int start, int end) {
        while (start > 0 && end < s.length()) {
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
