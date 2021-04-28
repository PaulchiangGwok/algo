package com.company.lcci;

import java.util.*;

public class ListOfDepth {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 3 };
        // int target = 10;
        ListOfDepth obj = new ListOfDepth();
        System.out.println(obj.listOfDepth(null));
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        Map<Integer, ListNode> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(1, tree));
        while (!queue.isEmpty()) {
            Node handle = queue.poll();
            ListNode listNode = map.get(handle.depth);
            if (listNode == null) {
                listNode = new ListNode(handle.node.val);
            } else {
                ListNode idx = listNode;
                while (idx.next != null) {
                    idx = idx.next;
                }
                idx.next = new ListNode(handle.node.val);
            }
            map.put(handle.depth, listNode);

            if (handle.node.left != null) {
                queue.offer(new Node(handle.depth + 1, handle.node.left));
            }

            if (handle.node.right != null) {
                queue.offer(new Node(handle.depth + 1, handle.node.right));
            }
        }

        ListNode[] list = map.values().toArray(new ListNode[0]);

        return list;
    }

    class Node {
        int depth;
        TreeNode node;

        Node(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
