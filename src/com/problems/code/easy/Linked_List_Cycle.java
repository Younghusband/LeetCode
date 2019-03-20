package com.problems.code.easy;

import java.util.HashSet;
import java.util.Set;

import com.problems.code.ListNode;

/**
 * @author mr_yo
 * 
 * 判断链表中是否包含环，如果包含环返回true，否则false
 * 
 * 收获: 
 * 进入环这个是很容易catch的，问题就在于如果不是环的情况不出错
 * 写代码的时候一开始用条件规避掉了一些边缘情况可以在完成所有代码的时候看看一开始的条件是否可以去掉。
 * 
 */
public class Linked_List_Cycle {
    
    // one-pass hash
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
    
    /**
     * slow and fast pointer
     * 我能说我现在的AC是一步一步磨出来的吗？
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next; //先走而非先判断 是为了规避 “最开始两者还没走就被误判为相遇”的情况
            if(fast == slow) {
                return true;
            }
        }
        return false;        
    }
    

}
