package com.company.old;

import java.util.*;
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        //int target = 10;

        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }

        if(nums.length == 2){
            return nums[0] == nums[1] ? 1 : 2;
        }

        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
    

        return left+1;
    }
}

