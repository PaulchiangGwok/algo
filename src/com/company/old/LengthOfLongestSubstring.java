package com.company.old;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        String input = "pwwkew";
        LengthOfLongestSubstring object = new LengthOfLongestSubstring();
        System.out.println(object.lengthOfLongestSubstring(input));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, start = 0, end = 0;
        while (start < length && end < length) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                ans = Math.max(ans, end - start);
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return ans;
    }
}

