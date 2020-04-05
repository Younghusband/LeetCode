package com.practice.xiaorong;


 // 删除链表中的重复元素


public class No83 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode t = head;
        while (t.next != null) {
            if (t.val == t.next.val) {
                t.next = t.next.next;
            } else {
                t = t.next;
            }
        }
        return head;
    }
}
