package com.company.old;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    // https://leetcode-cn.com/problems/find-the-difference/
    public static void main(String[] args) {
        System.out.println(findTheDifference2("abc", "abdc"));
    }

    public static char findTheDifference2(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        for (char c : s.toCharArray()) {
            sum1 += c;
        }

        for (char c : t.toCharArray()) {
            sum2 += c;
        }
        return (char) (sum2 - sum1);
    }

    public static char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }

        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            int i = map1.getOrDefault(c, 0);
            i++;
            map1.put(c, i);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            int i = map2.getOrDefault(c, 0);
            i++;
            map2.put(c, i);

            if (i > map1.getOrDefault(c, 0)) {
                return c;
            }
        }
        return 0;
    }
}
