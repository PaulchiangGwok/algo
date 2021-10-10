package com.company.old;

import java.util.*;

public class MinSetSize {
    public static void main(String[] args) {
        //String num = "/../";
        //System.out.print(simplifyPath(num));
        MinSetSize KWeakestRows = new MinSetSize();
        //int[][] input = {{1, 1, 0, 0, 0},
        //    {1, 1, 1, 1, 0},
        //    {1, 0, 0, 0, 0},
        //    {1, 1, 0, 0, 0},
        //    {1, 1, 1, 1, 1}};
        //int k = 3;
        int[] input = {1000, 1000, 3, 7};
        Object res =
            KWeakestRows.minSetSize(input);
        System.out.println();
    }

    public int minSetSize(int[] arr) {
        //WARN 要用equal
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //转成数组
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (o1, o2) -> {
            return -(o1 - o2);
        });

        int half = arr.length / 2;
        int sum = 0;
        int time = 0;
        for (int node : list) {
            sum = sum + node;
            time++;
            if (sum >= half) {
                break;
            }
        }
        return time;

    }

}
