package com.company;

import java.util.*;

public class MaximumProduct {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        // System.out.println(findBestValue(arr,target));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        return nums[0] * nums[1] * nums[length - 1] > nums[length-1] * nums[length-2] * nums[length-3] ?
        nums[0] * nums[1] * nums[length - 1]: nums[length-1] * nums[length-2] * nums[length-3];
    }
}
