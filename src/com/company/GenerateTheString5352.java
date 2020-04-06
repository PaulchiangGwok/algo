package com.company;

/**
 * @author baojiang create on 2020/3/1.
 */
public class GenerateTheString5352 {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        String input = "10#11#12";

        GenerateTheString5352 object = new GenerateTheString5352();
        Object res = object.generateTheString(2);
        System.out.println();
    }

    public String generateTheString(int n) {
        return doit(n,(char)97,"");
    }

    private String doit(int n, char add, String res) {
        if (n == 1) {
            res += add;
            return res;
        }

        int a = n / 2;
        if (a % 2 == 0) {
            a--;
        }

        for (int i = 0; i < a; i++) {
            res += add;
        }
        add++;
        return doit(n - a,add,res);
    }
}
