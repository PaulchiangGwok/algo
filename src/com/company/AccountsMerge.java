package com.company;

import java.util.*;

//https://leetcode-cn.com/problems/accounts-merge/
public class AccountsMerge {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        // System.out.println(findBestValue(arr,target));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }

        UnionFind uf = new UnionFind(emailCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIdx = emailToIndex.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int nextIdx = emailToIndex.get(nextEmail);
                uf.union(firstIdx, nextIdx);
            }
        }

        Map<Integer, List<String>> indexToEmail = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));//找到后的节点
            List<String> account = indexToEmail.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmail.put(index, account);
        }

        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmail.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int input) {
            if (parent[input] != input) {
                parent[input] = find(parent[input]);
            }
            return parent[input];
        }

        private void union(int input1, int input2) {
            parent[find(input2)] = find(input1);
        }
    }
}
