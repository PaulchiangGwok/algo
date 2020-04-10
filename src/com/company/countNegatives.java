package com.company;

public class countNegatives {

    public static void main(String[] args) {
//        int[] arr = {5,2,3};
        int target = 1010;
        //int time = countNegatives(58076, 49567, 394506);
//        int[] res = getNoZeroIntegers(target);
        System.out.println();
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] i:grid){
            for(int k:i){
                if(k<0)
                    count++;
            }
        }
        return count;
    }
}
