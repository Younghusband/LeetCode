package com.problems.code.easy;

/**
 * @author mr_yo
 * 判断链表中是否有环进阶版
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class Linked_List_Cycle_II {
    
    /**
     * Step1: judge if cycle exists
     * Step2: get the entry node of the cycle
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) {
                ListNode slow2 = head;
                while(slow2!=slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;                
            }
        }
        return null;
    }

}
