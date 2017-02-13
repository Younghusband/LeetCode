package com.yangfan.repository.list;
/************************************************
    * Description: 
    *      insertFirst insertLast deleteFirst  *deleteLast  display 
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月6日 上午10:56:53 
**************************************************/
public class FirstLastList {
     private class Data{
    	 private Object obj;
    	 private Data next = null;
    	 Data(Object x){
    		 this.obj = x;
    	 }
     }
     
     Data first = null;
     Data last = null;
     
     public void insertFirst(Object obj){
    	 Data data = new Data(obj);
    	 if(first==null)
    		 last=data;  
    	 data.next = first;
    	 first = data;
     }
     
    public void insertLast(Object obj){
    	 Data data = new Data(obj);
    	 if(first==null){
    		 first = data;
    	 }else{
    		last.next = data;
    	 }
    	 last = data;
     }
    
    public Object deleteFirst()throws Exception{
    	if(first==null)
    		throw new Exception("empty!");
    	Data temp = first;
    	if(first.next==null)
    		last = null;
    	first = first.next;   //if first.next = null that means first = null
    	return temp.obj;
    }
    
    public void deleteLast()throws Exception{
    	if(first==null)
    		throw new Exception("empty!");
    	if(first.next==null){  //single node scenario
    		first = null;
    		last = null;
    	}else{
    		Data cur = first;
    		while(cur.next!=null){  //stop by end
    			if(cur.next==last){
    				last = cur;
    				last.next = null;
     				break;   //这个break似乎没卵用啊？？ 反正都到最后一个点了  加上也就少执行一次cur = cur.next
    			}
    			cur = cur.next;
    		}
    	}
    }
     
    public void display()throws Exception{
    	if(first == null)
    		throw new Exception("your list is empty");
    	Data cur = first;
    	while(cur!=null){
    		System.out.print(cur.obj.toString()+"->");
    		cur = cur.next;
    	}
    	System.out.println();
    }
     
    public static void main(String[] args) throws Exception {
   	 FirstLastList fll = new FirstLastList();  
        fll.insertFirst(2);  
        fll.insertFirst(1);  
        fll.display();  
        fll.insertLast(3);  
        fll.display();  
        fll.deleteFirst();  
        fll.display();  
        fll.deleteLast();  
        fll.display();  
	}
}
