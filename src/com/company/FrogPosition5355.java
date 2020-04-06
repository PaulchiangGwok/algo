package com.company;

import java.util.*;

/**
 * @author baojiang create on 2020/3/1.
 */
public class FrogPosition5355 {

    public static void main(String[] args) {

        FrogPosition5355 object = new FrogPosition5355();
        int[][] edge = {{2,1},{3,2},{4,1}};
        Object res = object.frogPosition(1, edge, 4, 1);
        System.out.println(res);
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(edges.length == 0){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> submap = new HashMap<>();
        for (int[] edge : edges) {
            Arrays.sort(edge);
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            submap.put(edge[1], edge[0]);
        }
        if(target == 1){
            if(map.get(target) != null && !map.get(target).isEmpty() ){
                return 0;
            }
        }

        int targetSub = submap.get(target);
        double ratio = 1;
        int floor = 1;
        while (true) {
            List<Integer> l = map.get(targetSub);
            if (l == null || l.isEmpty()) {
                break;
            }
            ratio = ratio / l.size();
            if(submap.get(targetSub) == null){
                break;
            }
            targetSub = submap.get(targetSub);
            floor++;
        }

        //还没到
        if (floor > t) {
            return 0;
        } else if (floor == t) {
            return ratio;
        }

        if (map.get(target) == null || map.get(target).isEmpty()) {
            return ratio;
        } else {
            //过了
            return 0;
        }
    }
}
