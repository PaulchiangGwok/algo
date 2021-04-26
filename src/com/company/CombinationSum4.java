package com.company;

import java.util.*;

public class CombinationSum4 {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 4;
        CombinationSum4 obj = new CombinationSum4();
        Object res = obj.combinationSum4(arr, target);

        System.out.println("Hello Worlds");
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        Arrays.sort(nums);

        for(int i = 1;i<=target;i++){
            for(int n:nums){
                if(n > i){
                    break;
                }
                //假设入参target = 10，nums[2,3,5]
                //目前计算到i=5，n=2. 那就是5-2=3. 拿到3有多少种方式
                //下一步是n=3 ，那就是5-3=2 拿到2有多少种选择
                dp[i] += dp[i-n];
            }
        }

        return dp[target];
    }
}

