package com.company;

import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
         int[] arr = new int[]{ 3,30,34,5,9 };
         String res = "9534330";
         if(!res.equals (largestNumber(arr))){
            System.out.println(false);
         }

         arr = new int[]{111311, 1113};
         res = "1113111311";
         if(!res.equals (largestNumber(arr))){
            System.out.println(false);
         }
        
         arr = new int[]{34323,3432};
         res = "343234323";
         if(!res.equals (largestNumber(arr))){
            System.out.println(false);
         }
    }

   
        public static String largestNumber(int[] nums) {
        List<String> stringList = new LinkedList<>();
        boolean allZero = true;
        for (int num : nums) {
            if(num != 0){
                allZero = false;
            }
            stringList.add(String.valueOf(num));
        }
        if(allZero) {
            return "0";
        }

        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo((o2+o1));            
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String t : stringList) {
            sb.append(t);
        }
        return sb.toString();
    
    }

}
