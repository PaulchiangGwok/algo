package com.company;

import java.util.*;

public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = { 3,2,2,3};
        int target = 2;

        System.out.println(removeElement(arr, target));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == val) {
                nums[0] = 0;
                return 0;
            } else {
                return 1;
            }
        }

        int l = 0, r = nums.length - 1,match = 0;

        while(l<r){
            //先找能交换的位置
            while(nums[r]==val && r>l){
                r--;
            }
            
            //找要交换的的值
            while(l<r){
                if(nums[l]==val){
                    match++;
                    nums[l] = nums[r];
                    nums[r] = val;
                    l++;
                    break;
                }
                l++;
            }
        }

        return nums[r]==val?r:r+1;
    }
}
