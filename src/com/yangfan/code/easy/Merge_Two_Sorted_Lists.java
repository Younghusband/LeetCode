package com.yangfan.code.easy;
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
		//哈哈
		
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
    
    
    

}
