package com.company;

import java.util.*;

public class SumFourDivisors {

    public static void main(String[] args) {
        //int[][] x = {{6, 6}, {3, 4}, {22, 26}, {29, 32}, {8, 10}, {8, 9}, {30, 30}, {19, 21}, {30, 34}, {20, 20},
        //    {29, 32}, {4, 5}, {16, 17}, {3, 3}, {14, 16}, {9, 10}, {2, 5}, {7, 11}, {3, 3}, {18, 20}, {26, 28},
        //    {15, 19}, {26, 27}, {22, 22}, {2, 3}, {16, 20}, {2, 3}, {23, 27}, {25, 28}, {17, 20}};

        System.out.println();
    }

    public int sumFourDivisors(int[] nums) {
        //Arrays.sort(nums);
        int sum = 0;
        for(int i:nums){
            Set<Integer> set = getDivisors(i);
            if(set.size()==4){
               for(int t:set){
                   sum+=t;
               }
            }
        }
        return sum;
    }

    private Set<Integer> getDivisors(int input){
        Set<Integer> set = new HashSet<>();
        for(int i=1;i<=input/2;i++){
            if(input % i == 0){
                set.add(i);
                set.add(input/i);
            }
        }

        return set;
    }
}
