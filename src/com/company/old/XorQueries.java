package com.company.old;

import java.util.*;

public class XorQueries {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8 };
        int[][] query = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };

        System.out.println(xorQueries(arr, query));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] prefix = new int[arr.length];

        // pre-handle
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n = n ^ arr[i];
            prefix[i] = n;
        }

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if (a == b) {
                result[i] = arr[a];
            } else if (a == 0) {
                result[i] = prefix[queries[i][1]];
            } else {
                result[i] = prefix[queries[i][1]] ^ prefix[queries[i][0] - 1];
            }
        }

        return result;
    }
}
