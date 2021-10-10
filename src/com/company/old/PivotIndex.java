package com.company.old;

import java.util.*;

public class PivotIndex {

    public static void main(String[] args) {
        // int[] arr = {1, 7, 3, 6, 5, 6};
        int[] arr = {1,-1,-2,1,1,1};

        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }


        int l = 0;
        int r = sum - l;
        for (int i = 0; i < nums.length; i++) {
            r -= nums[i];
            if(l == r){
                return i;
            } 

            l += nums[i];
        }

        return -1;
    }
}
