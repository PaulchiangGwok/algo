package com.company;

import java.util.*;

public class NthUglyNumber {
    
    
    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;
        int res = nthUglyNumber(1407);
        System.out.println(res);
    }

    public static int nthUglyNumber(int n) {
        int time = n;
        Queue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set= new HashSet<>();
        queue.add(1L);
        set.add(1L);
        while (--time > 0) {
            long handle = queue.poll();
            // System.out.print(handle+" ");
            add(handle * 2, n, queue, set);
            add(handle * 3, n, queue, set);
            add(handle * 5, n, queue, set);
        }
        return queue.poll().intValue();
    }

    private static void add(long n,int request,Queue<Long> queue,HashSet<Long> set){
        if (!set.contains(n)) {
            queue.add(n);
            set.add(n);
        }
    }
}
