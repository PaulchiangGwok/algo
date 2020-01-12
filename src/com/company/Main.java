package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5,2,3};
        int target = 10;

        System.out.println(findBestValue(arr,target));
    }

    public static int findBestValue(int[] arr, int target) {

        int l = 0, r;
        r = getMaxForList(arr) ;

        while(l<r){
            int mid = (l + r) / 2;
            int sum = sum(arr,mid);

            if(sum > target){
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return Math.abs(sum(arr,l) - target) <  Math.abs(sum(arr,l - 1) - target)? l : l - 1;
    }

    private static int sum(int[] arr, int value){
        int sum = 0;
        for(int s:arr){
            sum += Math.min(s,value);
        }
        return sum;
    }

    private static int getMaxForList(int[] arr) {
        int max = 0;
        for (int s : arr) {
            if (s > max)
                max = s;
        }
        return max;
    }
}

