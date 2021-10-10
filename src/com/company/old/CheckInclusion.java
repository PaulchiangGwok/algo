package com.company.old;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class CheckInclusion {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        CheckInclusion object = new CheckInclusion();
        System.out.println(object.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            count = s1Map.getOrDefault(s1.charAt(i), 0);
            count++;
            s1Map.put(s1.charAt(i), count);

            count = s2Map.getOrDefault(s2.charAt(i), 0);
            count++;
            s2Map.put(s2.charAt(i), count);
        }
        if (s1Map.equals(s2Map)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char remove = s2.charAt(i - s1.length());
            char add = s2.charAt(i);

            count = s2Map.getOrDefault(add, 0);
            count++;
            s2Map.put(add, count);

            count = s2Map.getOrDefault(remove, 0);
            count--;
            if(count>0) {
                s2Map.put(remove, count);
            }else {
                s2Map.remove(remove);
            }

            if (s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }
}

