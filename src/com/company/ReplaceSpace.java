package com.company;

import java.util.*;

public class ReplaceSpace {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;

        System.out.println(replaceSpace("Hello Worlds"));
    }

    public static  String replaceSpace(String s) {
        if(s == null || s.isBlank()){
            return s;
        }

        return s.replaceAll(" ","%20");
    }
}

