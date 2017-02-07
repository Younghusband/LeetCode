package com.yangfan.code;
/************************************************
    * Description: 
    * 
    * Merge two sorted linked lists and return it as a new list. 
    * The new list should be made by splicing together the nodes of the first two lists.
    * 
    * method 1: common solution
    * method 2: use recursion
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月4日 上午10:22:15 
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
		//该怎么写测试用例呢... 
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        
        ListNode cur = null;
        
        if(l1.val<l2.val){
        	cur = l1;
        	cur.next = mergeTwoLists(l1.next,l2);
        }else{
        	cur = l2;
        	cur.next = mergeTwoLists(l1,l2.next);
        }
    	return cur;
    }
    
    public ListNode mergeTwoLists_fast(ListNode l1,ListNode l2){
        
    	
    	return null;
    }
    
    

}
