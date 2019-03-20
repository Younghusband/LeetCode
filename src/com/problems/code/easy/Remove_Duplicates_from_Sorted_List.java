package com.problems.code.easy;

import com.problems.code.ListNode;
/************************************************
    * Description: 
    *    Given a sorted linked list, delete all duplicates such that each element appear only once.
         For example,
         Given 1->1->2, return 1->2.
         Given 1->1->2->3->3, return 1->2->3. 
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月3日 下午1:08:35 
**************************************************/
public class Remove_Duplicates_from_Sorted_List {
       public static void main(String[] args) throws Exception {
    	   SortedList s1 = new SortedList();
    	   s1.insert(1);
    	   s1.insert(1);
    	   s1.insert(2);
    	   s1.insert(3);
    	   s1.insert(3);
    	   s1.display();
	}
       
    
       /**
        * recursive way
        */
       public static ListNode deleteDuplicatesPro(ListNode head) {  //理解为 ListNode为有序链表的头结点
    	   if(head == null || head.next == null)return head;
           head.next = deleteDuplicatesPro(head.next);
           return head.val == head.next.val ? head.next : head;
          }
       
    /**
     * one pointer solution
     */
    public static ListNode deleteDuplicates1(ListNode head) {  //理解为 ListNode为有序链表的头结点
           if(head==null) return null;
    	   ListNode list = head;
    	   while(list!=null){
    		   if(list.next == null) break;
    		   if(list.val==list.next.val){
    			   list.next = list.next.next;
    		   }else{
    			   list = list.next;
    		   }
    	   }
    	   return head;
       }
    
    /**
     * two pointers solution
     */
    public static ListNode deleteDuplicates2(ListNode head) {  //理解为 ListNode为有序链表的头结点
           if(head==null) return null;
    	   ListNode pre = head;
    	   ListNode cur = head.next;
    	   while(cur!=null){
    		   if(pre.val<cur.val){
    			   pre = cur;
    			   cur = cur.next;
    		   }else{
    			   cur = cur.next;
    			   pre.next = cur;
    		   }
    	   }
    	   return head;
       }
}


/**
 * insert deleteFirst display
 *
 */
class SortedList{
   class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
   
   private ListNode first = null;
   
   public void insert(int val){
	   ListNode data = new ListNode(val);
	   ListNode pre = null;
	   ListNode cur = first;
	   while(cur!=null&&data.val>cur.val){
		   pre = cur;
		   cur = cur.next;
	   } //第一步  定位
	   if(pre==null)  //坐标并未移动
		   first = data;  //这个地方如果 cur = data 就错了  思考为什么
	   else
		   pre.next = data;
	   data.next = cur;
   }
   
   public int deleteFirst()throws Exception{
	   if(first==null)
		   throw new Exception("your list is null");
	   ListNode temp = first;
	   first = first.next;
	   return temp.val;
   }
   
   public void display()throws Exception{
	   if(first==null)
		   System.out.println("your list is empty");
	   ListNode cur = first;
	   while(cur!=null){
		   System.out.print(cur.val+"->");
	       cur = cur.next;
	   }
	   System.out.println();
   }
   
   
   
}