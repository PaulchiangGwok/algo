package com.company;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(input));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int lidx = 0;
        int ridx = nums.length - 1;

        Set<String> res = new HashSet<>();

        boolean hasZero = false;
        for (int n : nums) {
            if (n == 0) {
                hasZero = true;
            }
        }

        while (lidx + 1 < ridx - 1) {
            if (nums[lidx] + nums[ridx] > 0) {
                if (nums[lidx] + nums[ridx] + nums[lidx + 1] == 0) {
                    res.add(nums[lidx] + "," + nums[lidx + 1] + "," + nums[ridx]);
                }
                lidx++;
            } else if (nums[lidx] + nums[ridx] < 0) {
                if (nums[lidx] + nums[ridx] + nums[ridx - 1] == 0) {
                    res.add(nums[lidx] + "," + nums[ridx - 1] + "," + nums[ridx]);
                }
                ridx--;
            } else {
                if (hasZero) {
                    res.add(nums[lidx] + ",0," + nums[ridx]);
                }
                lidx++;
            }
        }

        //parse result
        List<List<Integer>> ans = new ArrayList<>();
        for(String s : res){
            String[] arr = s.split(",");
            List<Integer> t = new ArrayList<>(3);
            t.add(Integer.parseInt(arr[0]));
            t.add(Integer.parseInt(arr[1]));
            t.add(Integer.parseInt(arr[2]));
            ans.add(t);
        }
        return ans;
    }
}
