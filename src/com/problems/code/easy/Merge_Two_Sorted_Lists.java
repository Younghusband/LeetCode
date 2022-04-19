package com.problems.code.easy;

import com.problems.dataobject.ListNode;

/************************************************
    * Description: 
    * 
    * Merge two sorted linked lists and return it as a new list. 
    * The new list should be made by splicing together the nodes of the first two lists.
    * 
    * 1. 递归方式
    * 2. 利用哑节点头
**************************************************/

public class Merge_Two_Sorted_Lists {
	
	public static void main(String[] args) {
		//哈哈
	    Merge_Two_Sorted_Lists service = new Merge_Two_Sorted_Lists();
	    ListNode l1 = null;
	    ListNode l2 = new ListNode(0);
	    
	    ListNode x = service.mergeTwoListsPro(l1, l2);
	    while(x!=null) {
	        System.out.println(x.val);
	        x = x.next;
	    }
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.val<l2.val){
        	l1.next = mergeTwoLists(l1.next,l2);
        	return l1;
        }else{
        	l2.next = mergeTwoLists(l1,l2.next);
        	return l2;
        }
    }
    
    /**
     * 简洁的方法
     */
    public ListNode mergeTwoListsBest(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cursor = result;
        ListNode tmp; // 用于保存未合并完 剩余的节点（要么全在l1, 要么全部在l2）
        
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next; // 记得将指针递进
        }
        tmp = l1 != null ? l1 : l2;
        cursor.next = tmp;
        return result.next;
    }
    
    
    public ListNode mergeTwoListsPro(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

}
