package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    public static void main(String[] args) {
        //        int[] arr = {5,2,3};
        int target = 1010;
        //int time = countNegatives(58076, 49567, 394506);
        //        int[] res = getNoZeroIntegers(target);
        System.out.println();
    }

    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if(num == 0){
            list = new ArrayList<>();
            list.add(1);
        } else {
            list.add(list.get(list.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if(list.size() <= k){
            return 0;
        } else {
            return list.get(list.size() - 1) / list.get(list.size() - 1 - k);
        }
    }

}
