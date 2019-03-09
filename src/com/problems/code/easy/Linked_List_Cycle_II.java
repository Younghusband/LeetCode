package com.problems.code.easy;

/**
 * @author mr_yo
 * 判断链表中是否有环进阶版
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * 
 * 假设从head到环入口的距离为 Len
 *     环入口到快慢节点相遇点的距离为 x
 *     环的长度为R
 *     快节点在环内转了n圈
 *     那么可以推导出   Len = nR-x
 *     推导过程见博客
 *     所以，设置一个从head开始跑的慢节点与在环内相遇点的慢节点同时跑，最终会在入口处相遇(理解一下nR-x, 就懂了)
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
