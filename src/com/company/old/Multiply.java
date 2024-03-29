package com.company.old;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Multiply {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        Multiply object = new Multiply();
        System.out.println(object.multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if (n1 < 0 || n2 < 0) { return ""; }
        int[] mul = new int[n1 + n2 + 2];

        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                int bitmul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                bitmul += mul[i+j+1];

                mul[i+j] += bitmul/10;
                mul[i+j+1] = bitmul%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while(i < mul.length-1 && mul[i] == 0)
            i++;
        for(; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();
    }
}

