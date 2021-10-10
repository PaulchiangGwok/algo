package com.company.old;

import java.util.*;

public class IsPossible5343 {

    public static void main(String[] args) {
        //int[] h = {1,1,1,2};
        int[] h = {9,3,5};
        //int[] h = {1,1384,1,1,10,2767,379,1,217,1};
        IsPossible5343 obj = new IsPossible5343();
        System.out.println(obj.isPossible(h));
    }

    public boolean isPossible(int[] target) {
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (int i : target) {
            res.add(i);
            max += i;
        }
        Collections.sort(res);
        List<Integer> handle = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            handle.add(1);
        }

        //res 是目标数组
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(handle);
        HashSet<String> set = new HashSet<>();
        while (!stack.isEmpty()) {
            List<Integer> h = stack.pop();
            int sum = 0;
            for (int i : h) {
                sum += i;
            }

            for (int i = 0; i < target.length; i++) {
                List<Integer> newlist = new ArrayList<>();
                for (int k = 0; k < h.size(); k++) {
                    if (k == i) {
                        newlist.add(sum);
                    } else {
                        newlist.add(h.get(k));
                    }
                }
                Collections.sort(newlist);
                //判断是不是相等
                if(judgeAndPush(newlist,res,max,set,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judgeAndPush(List<Integer> newlist,List<Integer> res,int max,HashSet<String> set,Stack<List<Integer>> stack ){
        boolean mark = false;
        for (int k = 0; k < newlist.size(); k++) {
            if (res.get(k) != newlist.get(k)) {
                mark = true;
                int newsum = 0;
                String a = "";
                for (int x : newlist) {
                    newsum += x;
                    a = a + x +"/";
                }
                if (newsum < max &&! set.contains(a)) {
                    stack.push(newlist);
                    set.add(a);
                    break;
                }
            }
        }
        if (!mark) {
            return true;
        } else {
            return false;
        }
    }
}
