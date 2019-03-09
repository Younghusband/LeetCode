package com.problems.code.easy;
/************************************************
    * Description: 
    * 
    * Merge two sorted linked lists and return it as a new list. 
    * The new list should be made by splicing together the nodes of the first two lists.
    * 
    * 1. 递归方式
    * 2. 利用哑节点头
**************************************************/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

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
    
    
    public ListNode mergeTwoListsPro(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
    
    
    /**
     * 最好的方法
     */
    public ListNode mergeTwoListsBest(ListNode l1, ListNode l2) {
        
        
        return null;
    }
    
    
    

}
