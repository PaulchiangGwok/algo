package com.company.lcci;

import java.util.*;

public class Subsets {

    // 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
    // 说明：解集不能包含重复的子集。
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3 };
        // int target = 10;

        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> emp = new ArrayList<>();
        res.add(emp);
        procress(0, nums, emp, res);
        return res;
    }

    // 只往后遍历即可,就不需要去重了
    public static void procress(int pos, int[] nums, List<Integer> alreadyList,
            List<List<Integer>> res) {
        for (int i = pos; i < nums.length; i++) {
            alreadyList.add(nums[i]);
            res.add(new ArrayList<>(alreadyList));
            procress(i + 1, nums, alreadyList, res);
            alreadyList.remove(alreadyList.size() - 1);
        }
    }
}
