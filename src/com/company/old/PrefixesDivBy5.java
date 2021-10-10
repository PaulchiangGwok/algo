package com.company.old;

import java.util.*;

public class PrefixesDivBy5 {

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,1,1};
        // int target = 10;

        System.out.println(prefixesDivBy5(arr));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);

        int value = 0;
        //超过32位有问题
        for (int t : A) {
            value = value << 1;
            value += t;
            value = value % 5;
            res.add(value == 0);
        }
        return res;
    }
}
