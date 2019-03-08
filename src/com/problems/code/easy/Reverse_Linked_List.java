package com.problems.code.easy;

import com.playground.linkedlist.ListNode;

public class Reverse_Linked_List {
    
    // 非递归方法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode tmp = null;
        while(head!=null){
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;        
    }
    
    // 递归方法
    public ListNode reverseRe(ListNode head){
        if(head==null||head.next ==null) { //空链表或者已经到链表末尾
            return head;
        }
        ListNode prev = reverseRe(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

}
