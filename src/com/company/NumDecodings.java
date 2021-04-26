package com.company;

import java.util.*;

public class NumDecodings {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;

        System.out.println(numDecodings2("12"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i = 1;i <=n;i++){
            if(s.charAt(i-1)!='0'){
                f[i] += f[i-1];
            }

            if(i > 1 && s.charAt(i - 2) != '0' &&((s.charAt(i-2) - '0')* 10 + (s.charAt(i-1) - '0') <= 26)){
                f[i] += f[i - 2];
            }
        } 
        return f[n];
    }

    public static int numDecodings2(String s) {
        int n = s.length();
        int a=0,b=1,c=0;
        for(int i = 1;i <=n;i++){
            c = 0;
            if(s.charAt(i-1)!='0'){
                c+=b;
            }

            if(i > 1 && s.charAt(i - 2) != '0' &&((s.charAt(i-2) - '0')* 10 + (s.charAt(i-1) - '0') <= 26)){
                c+=a;
            }
            a = b;
            b = c;
        } 
        return c;
    }
}

