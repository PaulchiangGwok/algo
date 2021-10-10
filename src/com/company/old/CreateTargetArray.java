package com.company.old;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CreateTargetArray {

    public static void main(String[] args) {
        //int[][] x = {{6, 6}, {3, 4}, {22, 26}, {29, 32}, {8, 10}, {8, 9}, {30, 30}, {19, 21}, {30, 34}, {20, 20},
        //    {29, 32}, {4, 5}, {16, 17}, {3, 3}, {14, 16}, {9, 10}, {2, 5}, {7, 11}, {3, 3}, {18, 20}, {26, 28},
        //    {15, 19}, {26, 27}, {22, 22}, {2, 3}, {16, 20}, {2, 3}, {23, 27}, {25, 28}, {17, 20}};

        int[][] x= {{1,4},{4,4},{2,2},{3,4},{1,1}};
        System.out.println();
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();

        for(int i=0;i<index.length;i++){
            list.add(index[i],nums[i]);
        }

        int[] res = new int[list.size()];
        for(int i=0;i<index.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
