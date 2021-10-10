package com.company.old;

import java.util.*;
public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        int[] arr = {2147483647,-1,2147483647};
        //int target = 10;

        System.out.println(containsNearbyAlmostDuplicate(arr,1,2147483647));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // if (nums.length <= 1) {
        //     return false;
        // }

        // if (nums.length == 2) {
        //     return Math.abs((long)nums[0] - (long)nums[1]) <= t;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j <= i + k && j < nums.length; j++) {
        //         if(Math.abs((long)nums[i] - (long)nums[j]) <= t){
        //             return true;
        //         }
        //     }
        // }

        // return false;
        int length = nums.length;
        if(length == 0|| k==0){
            return false;
        }

        int l = 0;
        int r = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        while(r< length){
            Integer ceiliInteger = treeMap.ceilingKey(nums[r]);
            Integer floorKey = treeMap.floorKey(nums[r]);

            long min = Long.MAX_VALUE;
            if(ceiliInteger != null){
                min = ceiliInteger.longValue() - (long)nums[r];
            }

            if(floorKey != null){
                min = Math.min(min, (long)nums[r] - floorKey.longValue());
            }

            if(min <= t){
                return true;
            }

            //r移动 并在滑动窗口记录这个值有几个
            treeMap.put(nums[r], treeMap.getOrDefault(nums[r], 0) + 1);
            r++;

            if(r-l >k){
                //l移动
                if(treeMap.get(nums[l]) == 1){
                    treeMap.remove(nums[l]);
                } else {
                    treeMap.put(nums[l], treeMap.get(nums[l]) - 1);
                }
                l++;
            }
        }
        return false;
    }
}

