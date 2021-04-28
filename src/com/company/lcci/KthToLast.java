package com.company.lcci;

import java.util.*;

public class KthToLast {

    public static void main(String[] args) {
        int[] arr = { -10, -3, 0, 5, 9 };
        // int target = 10;
        SortedArrayToBST obj = new SortedArrayToBST();
        System.out.println(obj.sortedArrayToBST(arr));
    }

    public int kthToLast(ListNode head, int k) {
        // 题目保证能找到这个值 不做null判断
        ListNode target = head;
        ListNode cursor = head;
        for (int i = 0; i < k - 1; i++) {
            cursor = cursor.next;
        }

        while (cursor.next != null) {
            target = target.next;
            cursor = cursor.next;
        }

        return target.val;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
