package com.company;

import java.util.*;

public class Trie {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;

        System.out.println("Hello Worlds");
    }
    class TrieNode{
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(char c:word.toCharArray()){
            int u = c - 'a';
            if(p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return p.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return true;
    }
}

