package com.company;

public class Maximum69Number {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;

        System.out.println((maximum69Number(9996)));
    }

    public static int maximum69Number (int num) {
        String numString = String.valueOf(num);
        int res = 0;
        boolean mark = false;
        for (int i = 0; i < numString.length(); i++) {
            if (!mark && '6' == numString.charAt(i)) {
                res = res * 10 + 9;
                mark = true;
            } else {
                res = res * 10 + Integer.parseInt(numString.charAt(i) + "");
            }
        }
        return res;
    }
}

