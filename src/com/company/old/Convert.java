package com.company.old;

/**
 * @author baojiang create on 2020/3/1.
 */
public class Convert {
    public static void main(String[] args){
        String x = "[[3,4,3,4],[2,2,2,2],[6,5,6,5]]";
        x = x.replaceAll("\\[","{");
        x = x.replaceAll("\\]","}");
        System.out.println(x);
    }
}
