package com.company.lcci;

import java.util.*;

public class GenerateParenthesis {
    public static void main(String[] args) {
        // int[] arr = { 5, 2, 3 };
        // int target = 10;

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        procress("",n,n,res);
        return res;
    }

    public static void procress(String input, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(input);
            return;
        }

        // 一定要放左
        if (l >= r) {
            procress(input + "(", l - 1, r, res);
            return;
        }

        // 先放左
        if (l > 0) {
            procress(input + "(", l - 1, r, res);
        }
        // 再放右
        if (r > 0) {
            procress(input + ")", l, r - 1, res);
        }
    }
}