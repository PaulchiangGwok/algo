package com.company.old;


import java.util.*;

/**
 * @author baojiang create on 2020/3/1.
 */
public class NumOfMinutes5354 {

    public static void main(String[] args) {
        int[] arr = {2,2,-1,2,2,2};
        int[] time = {0,0,1,0,0,0};
        NumOfMinutes5354 object = new NumOfMinutes5354();
        Object res = object.numOfMinutes(7,2,arr,time);
        System.out.println(res);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //build tree
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int i1 = 0;
        for(int m:manager){
            List list = map.getOrDefault(m,new ArrayList<>());
            list.add(i1);
            map.put(m,list);
            i1++;
        }

        int[] notifyTime = new int[manager.length];
        //get -1
        Queue<Integer> handle = new LinkedList<>();
        handle.add(-1);
        while(!handle.isEmpty()) {
            int i = handle.poll();
            List<Integer> list = map.get(i);
            if(list == null || list.isEmpty()){
                continue;
            }
            for(int h:list){
                handle.add(h);
                if(h == headID){
                    continue;
                } else {

                    notifyTime[h] += notifyTime[i] + informTime[i];
                }
            }
        }
        int max = -1;

        for(int x:notifyTime){
            if(x >max){
                max =x ;
            }
        }

        return max;
    }
}
