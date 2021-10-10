package com.company.old;

import java.util.*;

public class CanCross {

    // https://leetcode-cn.com/problems/frog-jump/
    // 2021-04-29 13:45:56-2021-04-29 14:20:19
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,6,7,8,11};
        // int target = 10;

        System.out.println(canCross(arr));
    }

    public static boolean canCross(int[] stones) {
        if (stones.length == 2) {
            return stones[1] - stones[0] == 1;
        }

        if(stones[1] - stones[0] != 1){
            return false;
        }

        int finalVal = stones[stones.length-1];
        HashMap<Integer, Set<Integer>> dp = new HashMap<>(stones.length);
        for (int num : stones) {
            dp.put(num, new HashSet<Integer>());
        }

        // 第一跳一定是走了1步
        Set<Integer> step1 = dp.get(stones[1]);
        step1.add(1);

        for (int i = 1; i < stones.length; i++) {
            // 遍历处理能跳的位置
            int currentVal = stones[i];
            Set<Integer> lastStepSet = dp.get(currentVal);
            if (lastStepSet == null || lastStepSet.isEmpty()) {
                // 说明到不了这一步
                continue;
            }

            // 穷举一下每一步能走的3个next
            for (int lastStep : lastStepSet) {
                for (int j = -1; j <= 1; j++) {
                    int nextStep = lastStep + j;
                    if (nextStep > 0) {
                        int nextVal = currentVal + nextStep;
                        if(nextVal == finalVal){
                            return true;
                        }
                        if (dp.containsKey(nextVal)) {
                            dp.get(nextVal).add(nextStep);
                        }
                    }
                }
            }
        }

        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
