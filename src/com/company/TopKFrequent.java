package com.company;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {

//        System.out.print(simplifyPath(num));
    }

    public  static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> counter = new HashMap<>();
        for(String s:words){
            counter.put(s,counter.getOrDefault(s,0)+1);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>
                ((s1,s2)->counter.get(s1).equals(counter.get(s2))?
                        s2.compareTo(s1) //如果个数相同的时候 比较词的顺序 a 比 b前
                        :counter.get(s1).compareTo(counter.get(s2))); //否则比较出现次数大小
        for (String key : counter.keySet()) {
            if(maxHeap.size() < k){
                maxHeap.add(key);
            } else if (maxHeap.comparator().compare(key, maxHeap.peek()) > 0){
                maxHeap.poll();
                maxHeap.add(key);
            }
        }

        String[] res = new String[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = maxHeap.poll();
        }

        return Arrays.asList(res);

    }
}
