package com.company.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KWeakestRows {
    public static void main(String[] args) {
        //String num = "/../";
        //System.out.print(simplifyPath(num));
        KWeakestRows KWeakestRows = new KWeakestRows();
        int[][] input = {{1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}};
        int k = 3;
        Object res = KWeakestRows.kWeakestRows(input, k);
        System.out.println();
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Node> list = new ArrayList<>();

        int i = 0;
        for (int[] input : mat) {
            Node node = new Node();
            node.name = i;
            int count = 0;
            for (int x : input) {
                if (x == 1) {
                    count++;
                } else {
                    break;
                }
            }
            node.count = count;
            list.add(node);
            i++;
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.name - o2.name;
            }
            return o1.count - o2.count;
        });

        int[] res = new int[k];
        for (int m = 0; m < k; m++) {
            res[m] = list.get(m).name;
        }
        return res;
    }

    class Node {
        int name;
        int count;
    }
}
