package com.company.old;

import java.util.*;

public class IsPossible5343N {

    public static void main(String[] args) {
        //int[] h = {1,1,1,2};
        int[] h = {9,3,5};
        //int[] h = {1,1384,1,1,10,2767,379,1,217,1};
        IsPossible5343N obj = new IsPossible5343N();
        System.out.println(obj.isPossible(h));
    }

    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(int x:target){
            sum += x;
            pq.add((long)x);
        }

        while(sum != target.length){
            long cur = pq.poll();
            long rest = sum - cur;
            long pre = cur - rest;

            if(pre >= cur || pre < 1){
                return false;
            }
            sum = cur;
            pq.offer(pre);
        }
        return true;
    }
}
