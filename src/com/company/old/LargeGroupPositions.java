package com.company.old;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;
        String s = "babaaaabbb";
        System.out.println(largeGroupPositions(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        int left = 0;
        int right = left + 1;
        List<List<Integer>> res = new ArrayList<>();
        if (s.length() < 3) {
            return res;
        }

        while (right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                if (right - left >= 3) {
                    List<Integer> singleRes = new ArrayList<>();
                    singleRes.add(left);
                    singleRes.add(right - 1);
                    res.add(singleRes);
                }
                left = right;
            }
            right++;
        }

        if (s.charAt(left) == s.charAt(right - 1) && right - left >= 3) {
            List<Integer> singleRes = new ArrayList<>();
            singleRes.add(left);
            singleRes.add(right - 1);
            res.add(singleRes);
        }
        return res;
    }
}
