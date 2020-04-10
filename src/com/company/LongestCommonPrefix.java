package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        String[] input = {"dog","racecar","car"};
        LongestCommonPrefix object = new LongestCommonPrefix();
        System.out.println(object.longestCommonPrefix(input));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = "";
        int length = strs.length;
        int minString = Integer.MAX_VALUE;
        for (String t : strs) {
            if (t.length() < minString) {
                minString = t.length();
            }
        }

        while (prefix.length() < minString) {
            boolean add = true;
            for (int i = 1; i < length; i++) {
                if (strs[0].charAt(prefix.length()) != strs[i].charAt(prefix.length())) {
                    add = false;
                    break;
                }
            }
            if (add) {
                prefix += strs[0].charAt(prefix.length());
            } else {
                break;
            }
        }
        return prefix;
    }
}

