package com.company.old;

public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 直接弄个新的吧
        ListNode res;
        if (l1.val < l2.val) {
            res = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            res = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode ops = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ops.next = l2;
                break;
            } else if (l2 == null) {
                ops.next = l1;
                break;
            }

            if (l1.val < l2.val) {
                ops.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                ops.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            ops = ops.next;
        }

        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
