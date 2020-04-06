package com.company;


import java.util.*;

public class HasValidPath {

    public static void main(String[] args) {
        int[][] x ={{3,4,3,4},{2,2,2,2},{6,5,6,5}};
        HasValidPath obj = new HasValidPath();
        Object res =obj.hasValidPath(x);

        System.out.println();
    }

    public static int[][][] accessList = {{{1,4, 6}, {}, {1,3, 5}, {}}, {{}, {2,3, 4}, {}, {2, 5, 6}},
        {{1, 4, 6}, {}, {}, {2, 5, 6}}, {{}, {}, {1, 3, 5}, {2, 5, 6}}, {{1, 4, 6}, {2, 3, 4}, {}, {}},
        {{}, {2, 3, 4}, {1, 3, 5}, {}}};

    public boolean hasValidPath(int[][] grid) {

        int i = grid.length;
        int j = grid[0].length;

        if(i==1 && j ==1){
            return true;
        }

        Map<String, Set<Integer>> accessMap = getMap();

        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        Pair<Integer, Integer> pair1 = new Pair<>(i - 1, j - 1);
        queue.add(pair1);
        visited.add(pair1);

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int type = grid[pair.getKey()][pair.getValue()];

            //上
            if (pair.getKey() - 1 >= 0) {
                if (accessMap.get(type - 1 + "-" + 1).contains(grid[pair.getKey() - 1][pair.getValue()])) {
                    if (pair.getKey() - 1 == 0 && pair.getValue() == 0) {
                        return true;
                    }
                    Pair<Integer, Integer> pair2 = new Pair<>(pair.getKey() - 1, pair.getValue());
                    if(!visited.contains(pair2)) {
                        queue.add(pair2);
                        visited.add(pair2);
                    }
                }
            }

            //左
            if (pair.getValue() - 1 >= 0) {
                if (accessMap.get(type - 1 + "-" + 0).contains(grid[pair.getKey()][pair.getValue() - 1])) {
                    if (pair.getKey() == 0 && pair.getValue() - 1 == 0) {
                        return true;
                    }
                    Pair<Integer, Integer> pair2 = new Pair<>(pair.getKey(), pair.getValue() - 1);
                    if(!visited.contains(pair2)) {
                        queue.add(pair2);
                        visited.add(pair2);
                    }
                }
            }

            //下
            if (pair.getKey() + 1 < i) {
                if (accessMap.get(type - 1 + "-" + 3).contains(grid[pair.getKey() + 1][pair.getValue()])) {
                    if (pair.getKey() + 1 == 0 && pair.getValue() == 0) {
                        return true;
                    }
                    Pair<Integer, Integer> pair2 = new Pair<>(pair.getKey() + 1, pair.getValue());
                    if(!visited.contains(pair2)) {
                        queue.add(pair2);
                        visited.add(pair2);
                    }
                }
            }

            //右
            if (pair.getValue() + 1 < j) {
                if (accessMap.get(type - 1 + "-" + 2).contains(grid[pair.getKey()][pair.getValue() + 1])) {
                    if (pair.getKey() == 0 && pair.getValue() + 1 == 0) {
                        return true;
                    }
                    Pair<Integer, Integer> pair2 = new Pair<>(pair.getKey(), pair.getValue() + 1);
                    if(!visited.contains(pair2)) {
                        queue.add(pair2);
                        visited.add(pair2);
                    }
                }
            }
        }
        return false;
    }

    private Map<String, Set<Integer>> getMap() {
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < accessList.length; i++) {
            int[][] m = accessList[i];

            for (int k = 0; k < m.length; k++) {
                HashSet<Integer> s = new HashSet<>();
                for (int x : m[k]) {
                    s.add(x);
                }
                map.put(i + "-" + k, s);
            }
        }
        return map;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public Pair( K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (this.key != null ? this.key.hashCode() : 0);
            hash = 31 * hash + (this.value != null ? this.value.hashCode() : 0);
            return hash;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (!(o instanceof Pair)) {
                return false;
            } else {
                Pair pair = (Pair)o;
                if (this.key != null) {
                    if (!this.key.equals(pair.key)) {
                        return false;
                    }
                } else if (pair.key != null) {
                    return false;
                }

                if (this.value != null) {
                    if (!this.value.equals(pair.value)) {
                        return false;
                    }
                } else if (pair.value != null) {
                    return false;
                }

                return true;
            }
        }
    }
}
