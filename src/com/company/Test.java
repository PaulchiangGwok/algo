package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Test {
    public static void main(String[] args) {
        int[] input = {7, 1, 6, 3, 3, 4,7};
        //int[] input = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        //int input = 4;
        //System.out.println(climbStairs(input));

        //List<Integer> list = new ArrayList<Integer>();

        int l = 0;
        while (l < input.length) {
            int lv = input[l];
            if (lv % 2 == 0) {
                int r = l + 1;
                while (r < input.length) {
                    int rv = input[r];
                    if (rv % 2 == 1) {
                        input[l] = rv;
                        input[r] = lv;
                        //l = r + 1;
                        break;
                    }
                    r++;
                }
            }
            l++;
        }






        //for(int i:input) {
        //    list.add(i);
        //}
        //list.sort((o1, o2) -> {
        //    if(o1 % 2 == o2% 2){
        //        return 0;
        //    } else if( o1 % 2 ==0){
        //        return 1;
        //    } else
        //        return -1;
        //});

        System.out.println();
    }
}
