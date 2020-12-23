package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        // System.out.println(findBestValue(arr,target));
    }

    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int i = 0;
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
