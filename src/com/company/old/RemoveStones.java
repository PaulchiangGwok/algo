package com.company.old;

import java.util.*;

public class RemoveStones {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        // System.out.println(findBestValue(arr,target));
    }

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for(int[] stone:stones){
            unionFind.union(stone[0] + 10001,stone[1]);
        }

        return stones.length - unionFind.getCount();
    }

    class UnionFind {
        private Map<Integer, Integer> parent;
        // 非连通节点数
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));// 找到最上层的节点 连接上
            }

            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                //说明本来就在一起
                return;
            }

            parent.put(rootX, rootY);
            // 两个连通分量合并成为一个，连通分量的总数 -1
            // 因为这两个本来就是一个点 需要合并起来一起计算
            count--;
        }
    }
}
