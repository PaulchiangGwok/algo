package com.company.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] arr = {};
        // int target = 10;

        System.out.println(summaryRanges(arr));
    }

    public static List<String> summaryRanges(int[] nums) {
        Arrays.sort(nums);
        List<String> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        } else if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int left = 0;
        int right = 1;

        while (left < nums.length) {
            if (right >= nums.length) {
                if(left == right - 1){
                    res.add(String.valueOf(nums[left]));
                } else {
                    res.add(nums[left] + "->" + (nums[right - 1]));
                }
                break;
            }
            
            if(nums[right - 1] + 1 == nums[right]){
                right++;
            } else {
                if(left == right - 1){
                    res.add(String.valueOf(nums[left]));
                    left++;
                    right++;
                } else {
                    res.add(nums[left] + "->" + (nums[right - 1]));
                    left = right;
                    right++;
                }
            }
        }

        return res;
    }
}
