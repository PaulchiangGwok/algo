package com.company;

import java.util.*;

/**
 * @author baojiang create on 2020/3/1.
 */
public class FindMinArrowShots452 {
    public static void main(String[] args){
        FindMinArrowShots452 j = new FindMinArrowShots452();
        int[][] x = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        Object res = j.findMinArrowShots(x);
        System.out.println(res);
    }

    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1){
            return points.length;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int sum = 1;
        int end = points[0][1];
        for(int i = 1;i<points.length;i++){
            int[] point = points[i];
            if(point[0] > end){
                end = point[1];
                sum++;
            }
        }

        return sum;
    }
}
