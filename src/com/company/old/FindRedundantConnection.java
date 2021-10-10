package com.company.old;

import java.util.*;
//https://leetcode-cn.com/problems/redundant-connection/
public class FindRedundantConnection {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;
        int[][] req = { { 3, 4 }, { 1, 2 }, { 2, 4 }, { 3, 5 }, { 2, 5 } };
        System.out.println(findRedundantConnection(req));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] handle : edges) {
            Set<Integer> set0 = map.get(handle[0]);
            Set<Integer> set1 = map.get(handle[1]);
            if (set0 == null && set1 == null) {
                // 说明是两个点都还没接入
                set0 = new HashSet<>();
                set0.add(handle[1]);
                set0.add(handle[0]);

                map.put(handle[0], set0);
                map.put(handle[1], set0);
                continue;
            } else if (set1 == null) {
                // 说明handle[1] 是新的
                set0.add(handle[1]);
                map.put(handle[1], set0);
            } else if (set0 == null) {
                // 说明handle[0] 是新的
                set1.add(handle[0]);
                map.put(handle[0], set1);
            } else {
                // 都非空，看看0是否有1 1是否有0
                if (set1.contains(handle[0]) || set0.contains(handle[1])) {
                    return handle;
                } else {
                    set0.addAll(set1);
                    for (int k : set1) {
                        map.put(k, set0);
                    }
                }
            }
        }
        return null;
    }

    //并查集实现。。
    public int[] findRedundantConnection2(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
