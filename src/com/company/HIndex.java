package com.company;

import java.util.*;

public class HIndex {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    public int hIndex(int[] input) {
        int n = input.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }  
        }
        return n - left;
    }
}
