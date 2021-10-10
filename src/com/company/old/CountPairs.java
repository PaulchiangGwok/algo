package com.company.old;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode-cn.com/contest/weekly-contest-222/problems/count-good-meals/
//部分testcase过不了

public class CountPairs {

    public static void main(String[] args) {
        int[] req = { 1, 1, 1, 3, 3, 3, 7 };
        System.out.println(countPairs(req));
    }

    public static int countPairs(int[] deliciousness) {
        LinkedHashMap<Integer, Integer> counter = new LinkedHashMap<>();
        for (int i : deliciousness) {
            int k = counter.getOrDefault(i, 0);
            counter.put(i, ++k);
        }

        Set<Map.Entry<Integer, Integer>> set = counter.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        int[] nums = new int[counter.size()];
        int res = 0;
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int num = entry.getKey();
            int count = entry.getValue();
            if (count > 1 && isPowerOfTwo(num + num)) {
                // 判断本身是不是能当结果
                res = res + (combination(count, 2) % 1_000_000_007);
            }
            nums[i] = num;
            i++;
        }

        for (int k = 0; k < nums.length; k++) {
            for (int j = k + 1; j < nums.length; j++) {
                if (isPowerOfTwo(nums[k] + nums[j])) {
                    res = res + (counter.getOrDefault(nums[k], 0) % 1_000_000_007)
                            * (counter.getOrDefault(nums[j], 0) % 1_000_000_007);
                }
            }
        }
        return res % 1_000_000_007;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    private static int combination(int n, int k) {
        int a = 1, b = 1;
        if (k > n / 2) {
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            a *= (n + 1 - i) ;
            b *= i;
        }
        return a / b;
    }

}
