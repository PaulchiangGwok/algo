package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSteps {

    public static void main(String[] args) {
        //int[][] x = {{6, 6}, {3, 4}, {22, 26}, {29, 32}, {8, 10}, {8, 9}, {30, 30}, {19, 21}, {30, 34}, {20, 20},
        //    {29, 32}, {4, 5}, {16, 17}, {3, 3}, {14, 16}, {9, 10}, {2, 5}, {7, 11}, {3, 3}, {18, 20}, {26, 28},
        //    {15, 19}, {26, 27}, {22, 22}, {2, 3}, {16, 20}, {2, 3}, {23, 27}, {25, 28}, {17, 20}};
        int[] num = {6};
        System.out.println(numSteps("um"));
    }

    public static int numSteps(String s) {
        return 0;
    }

    private int count(String s,int step){
        if(s.length() == 1){
            return step;
        }

        int idx = s.length()-1;
        char handle = s.charAt(idx);
        if(handle == '0'){
            int x = handle--;
            while(s.charAt(x) != '1'){
                x--;
            }

            return count(s.substring(0,x),step + handle-x);
        } else {
            char pre = s.charAt(idx - 1);

        }
        return 0;
    }
}
