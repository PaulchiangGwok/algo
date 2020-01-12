package com.company;

public class GetNoZeroIntegers {

    public static void main(String[] args) {
//        int[] arr = {5,2,3};
        int target = 1010;
//
        int[] res = getNoZeroIntegers(target);
        System.out.println(getNoZeroIntegers(target));
    }

    public static int[] getNoZeroIntegers(int n) {

        for (int i = 1 ;i < n ;i++){
            if(containZero(i)){
                continue;
            }
            int r = n - i;
            if(containZero(r)){
                continue;
            } else {
                int [] res = new int [2];
                res[0] = i;
                res[1] = r;
                return res;
            }
        }
        return null;
    }

    private static boolean containZero(int x){
        String n = x+"";
        return n.contains("0");
    }
}
