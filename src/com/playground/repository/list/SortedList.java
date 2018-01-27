package com.playground.repository.list;
/************************************************
    * Description: 
    *        因为是有序的链表
    *        所以插入就不存在位置问题
    *        
    *        方法：
    *        insert  deleteFirst  display
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月6日 下午3:52:50 
**************************************************/
public class SortedList {
	 private class Data{  
	        private Object obj;  
	        private Data next = null;  
	          
	        Data(Object obj){  
	            this.obj = obj;  
	        }  
	    }  
	 
	 private Data first = null;
	 
	 public void insert(Object obj){
		 Data data = new Data(obj);
		 Data pre = null;
		 Data cur = first;
		 
		 while(cur!=null&&Integer.valueOf(data.obj.toString()).intValue()>
		 Integer.valueOf(cur.obj.toString()).intValue()){
			 pre = cur;
			 cur = cur.next;
		 }
		 if(pre==null)
			 first = data;
		 else
			 pre.next = data;
		 data.next = cur;
	 }
	 
	 public Object deleteFirst()throws Exception{
		 if(first==null)
			 throw new Exception("empty");
		 Data temp = first;
		 first = first.next;
		 return temp.obj;
	 }
	 
	 public void display(){
		 if(first == null)  
	            System.out.println("empty");  
	        System.out.print("first -> last : ");  
	        Data cur = first;  
	        while(cur != null){  
	            System.out.print(cur.obj.toString() + " -> ");  
	            cur = cur.next;  
	        }  
	        System.out.print("\n");
	 }
	 
	 
	 
	 public static void main(String[] args) throws Exception{
		 SortedList sl = new SortedList();  
	        sl.insert(80);  
	        sl.insert(2);  
	        sl.insert(100);  
	        sl.display();  
	        System.out.println(sl.deleteFirst());  
	        sl.insert(33);  
	        sl.display();  
	        sl.insert(99);  
	        sl.display();  
	}
}
