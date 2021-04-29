package com.company.lcci;

import java.util.*;

public class WordsFrequency {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    private Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>(book.length);

        for (String s : book) {
            Integer i = map.getOrDefault(s, 0);
            i++;
            map.put(s, i);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}
