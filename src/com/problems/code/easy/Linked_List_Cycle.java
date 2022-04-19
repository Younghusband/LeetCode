package com.problems.code.easy;

import java.util.HashSet;
import java.util.Set;

import com.problems.dataobject.ListNode;

/**
 * @author mr_yo
 * 141. Linked List Cycle
 * 判断链表中是否包含环，如果包含环返回true，否则false
 * 
 * 收获: 
 * 进入环这个是很容易catch的，问题就在于如果不是环的情况不出错
 */
public class Linked_List_Cycle {


    /**
     * slow and fast pointer
     * 经典思路
     * 快但内存占用大
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 快指针不为虚空且不是链表末尾
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; //先走而非先判断 是为了规避 “最开始两者还没走就被误判为相遇”的情况
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 内存小但耗时长
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    

}
