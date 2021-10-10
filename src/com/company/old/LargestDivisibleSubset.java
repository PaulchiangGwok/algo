package com.company.old;

import java.util.*;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,9,15,30};
        //int target = 10;
        LargestDivisibleSubset obj = new LargestDivisibleSubset();
        Object res = obj.largestDivisibleSubset(arr);
        System.out.println("Hello Worlds");
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length ==1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return list;
        }

        Arrays.sort(nums);
        Node[] nodeArr = new Node[nums.length];
        nodeArr[0] = new Node(1,null,nums[0]);
        
        for(int i=1;i<nums.length;i++){
            Node maxNode = null;
            for(int k=0;k<i;k++){
                if(nums[i] % nums[k] == 0){
                    if(maxNode==null || nodeArr[k].depth > maxNode.depth){
                        maxNode = nodeArr[k];
                    } 
                }
            }
            if(maxNode!=null){
                nodeArr[i] = new Node(maxNode.depth+1,maxNode,nums[i]);
            } else {
                nodeArr[i] = new Node(1,null,nums[i]); 
            }
        }

        Node maxNode = nodeArr[0];
        for(int i=1;i<nums.length;i++){
            if(nodeArr[i].depth > maxNode.depth){
                maxNode = nodeArr[i];
            }
        }

        List<Integer> res = new LinkedList<>();
        res.add(maxNode.value);
        while(maxNode.sub!=null){
            maxNode = maxNode.sub;
            res.add(maxNode.value);
        }
        
        Collections.reverse(res);
        return res;
    }

    class Node{
        int depth;
        Node sub;
        int value;
        public Node(int depth,Node sub,int value){
            this.depth = depth;
            this.sub = sub;
            this.value = value;
        }
    }
}

