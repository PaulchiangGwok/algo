package com.company;

import java.util.ArrayList;
import java.util.List;

public class PrintVertically {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;
        String input = "TO BE OR NOT TO BE";
        PrintVertically object = new PrintVertically();
        Object res = object.printVertically(input);

        System.out.println();
    }

    public List<String> printVertically(String s) {
        String[] inputList = s.split(" ");

        List<String> res = new ArrayList<>();
        boolean mark = true;
        int i = 0;
        while (mark) {
            int finishCount = 0;
            StringBuilder sb = new StringBuilder();
            for (String t : inputList) {
                if (i < t.length()) {
                    sb.append(t.charAt(i));
                } else {
                    sb.append(" ");
                    finishCount++;
                }
            }
            if (finishCount == inputList.length) {
                mark = false;
            } else {
                res.add(trimRight(sb.toString()));
            }
            i++;
        }
        return res;
    }

    public String trimRight(String sString) {
        String sResult = "";

        if (sString.startsWith(" ")) {
            sResult = sString.substring(0, sString.indexOf(sString.trim().substring(0, 1))
                + sString.trim().length());
        } else { sResult = sString.trim(); }

        return sResult;
    }
}

