package com.company.lcci;

import java.util.*;

public class Permutation {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 3 };
        // int target = 10;

        System.out.println(permutation("qwe"));
    }

    public static String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        List<Character> available = new ArrayList<Character>();
        for(char c:S.toCharArray()){
            available.add(c);
        }
        procress("", res, available);
        String[] output = res.toArray(new String[0]);
        return output;
    }

    // 只往后遍历即可,就不需要去重了
    public static void procress(String input, List<String> res, List<Character> available) {
        if (available.size() == 0) {
            res.add(input);
            return;
        }

        for (int i = 0; i < available.size(); i++) {
            char c = available.get(i);
            available.remove(i);
            procress(input + c, res, available);
            available.add(i,c);
        }
    }
}
