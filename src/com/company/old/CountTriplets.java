package com.company.old;

import java.util.*;

public class CountTriplets {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    public int countTriplets(int[] arr) {
        int res = 0;
        if (arr.length <= 1) {
            return res;
        }
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum = sum ^ arr[j];
                if (sum == 0 && j > i) {
                    //看实例1中的一个结果（0， 1，2）、（0，2，2)
                    // 可以知道0 -2区间异或为0，这里 i 就是0， k 就是 2
                    //因为 j > i ; j <= k， 所以 j 可以取 1 或 2，也就是 k - i
                    //其实(j-i)区间里面 可以使用任意一个值作为分隔位
                    sum += (j - i);
                }
            }
        }
        return res;
    }
}
