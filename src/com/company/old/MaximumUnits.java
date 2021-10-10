package com.company.old;

import java.util.Arrays;
//https://leetcode-cn.com/contest/weekly-contest-222/problems/maximum-units-on-a-truck/
public class MaximumUnits {

    public static void main(String[] args) {
        int[][] req = {{5,10},{2,5},{4,7},{3,9}};
        System.out.println(maximumUnits(req,10));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            if (a[1] > b[1]) {
                return -1;
            } else if (b[1] > a[1]) {
                return 1;
            } else {
                return 0;
            }
        });

        int res = 0;
        for (int[] box : boxTypes) {
            if (truckSize <= 0) {
                break;
            }

            if (box[0] > truckSize) {
                res += truckSize * box[1];
                truckSize = 0;
            } else {
                res += box[0] * box[1];
                truckSize -= box[0];
            }
        }

        return res;
    }
}
