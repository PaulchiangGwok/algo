package com.company.old;

public class FreqAlphabets {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        String input = "10#11#12";

        FreqAlphabets object = new FreqAlphabets();
        Object res = object.freqAlphabets(input);
        System.out.println();
    }

    public String freqAlphabets(String s) {
        //from right to left
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char handle = s.charAt(i);
            if (handle == '#') {
                //连续取出两位
                i--;
                char a = s.charAt(i);
                i--;
                char b = s.charAt(i);
                String c = b + "" + a;

                res = translate(c) + res;
            } else {
                res = translate(handle + "") + res;
            }
        }
        return res;
    }

    private char translate(String i) {
        int v = Integer.parseInt(i);
        return (char)(v + 96);
    }
}

