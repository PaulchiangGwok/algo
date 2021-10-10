package com.company.old;

import java.util.*;

public class MakeConnected {

    public static void main(String[] args) {
        MakeConnected x = new MakeConnected();
        int[][] input ={{0,1},{0,2},{0,3},{1,2},{1,3}};
        int res = x.makeConnected(6,input);
        System.out.println();
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1){
            return -1;
        }
        int count = 0;


        //判断总共有多少个图 图-1 就是结果
        //建图
        HashMap<Integer,Node> map= new HashMap<>();
        for(int i= 0;i<n;i++){
            map.put(i,new Node(i, new HashSet<>()));
        }

        for(int[] input:connections){
            int l = input[0];
            int r= input[1];

            Node ln = map.get(l);
            ln.list.add(r);

            Node rn = map.get(r);
            rn.list.add(l);
        }

        boolean[] mark  = new boolean[n];
        for(int i=0;i<n;i++){
            if(mark[i]){
                continue;
            }else {
                //深度优先遍历
                search(mark,map.get(i),map);
                count++;
            }
        }

        return count - 1;
    }

    private void search(boolean[] mark,Node cur,Map<Integer,Node> map){
        Set<Integer> searched = new HashSet<>();
        Stack<Integer> queue = new Stack<>();

        searched.add(cur.name);
        queue.addAll(cur.list);
        mark[cur.name] = true;

        while(!queue.isEmpty()){
            int handle = queue.pop();
            Node node = map.get(handle);
            searched.add(node.name);
            mark[node.name] = true;
            for(int i:node.list){
                if(!searched.contains(i)){
                    queue.add(i);
                }
            }
        }
    }

    class Node{
        int name;
        Set<Integer> list;

        public Node(int name, Set<Integer> list) {
            this.name = name;
            this.list = list;
        }
    }
}
