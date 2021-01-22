package com.company;

import java.util.*;

public class AddToArrayForm {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        // System.out.println(findBestValue(arr,target));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = length - 1; i >= 0; i--) {
            int sum = A[i] + K % 10;
            K /= 10;
            
            if(sum >= 10){
                K++;
                sum -= 10;
            }
            list.push(sum);
        }

        for (; K > 0; K /= 10) {
            list.push(K % 10);
        }
        // Collections.reverse(list);
        return list;
    }
}
