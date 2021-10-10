package com.company.old;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode-cn.com/problems/last-stone-weight/
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] s = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(s));
    }

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(stones.length,Comparator.reverseOrder());

        for (int s : stones) {
            pq.add(s);
        }

        while (pq.size() >= 2) {
            int l = pq.poll();
            int r = pq.poll();

            int left = l - r;
            if (left != 0) {
                pq.add(Math.abs(left));
            }
        }

        if (pq.size() > 0) {
            return pq.poll();
        } else {
            return 0;
        }
    }
}
