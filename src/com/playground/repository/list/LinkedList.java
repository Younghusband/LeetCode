package com.playground.repository.list;
/************************************************
    * Description: 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月6日 上午9:28:14 
**************************************************/
public class LinkedList {

	public static void main(String[] args) {

	}
	
	class Data{
		Object obj;
		Data next = null;
		Data(Object obj){
			this.obj = obj;
		}
	}
	
	Data first = null;
	
	public void insertFirst(Object obj){
		Data data = new Data(obj);
		data.next = first;
		first = data;
	}
	
	public Object deleteFirst()throws Exception{
		if(first==null)
			throw new Exception("empty");
		Data temp = first;
		first = first.next;
		return temp.obj;
	}
	
	public Object find(Object obj)throws Exception{
		if(first==null)
			throw new Exception("empty");
		Data cur = first;
		while(cur!=null){
			if(cur.obj.equals(obj))
				return cur.obj;
			cur = cur.next;
		}
		return null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
    public void remove(Object obj)throws Exception{
    	if(first==null)
			throw new Exception("empty");
		if(first.obj.equals(obj)){   //单次
			first = first.next;
		}else{
			Data pre = first;
			Data cur = first.next;
			while(cur!=null){
				if(cur.obj.equals(obj)){
					pre.next = cur.next;
					break;
				}
				pre = cur;
				cur = cur.next;
			}
		}
    }
	
	public void removeAll(Object obj)throws Exception{
		if(first==null)
			throw new Exception("empty");
		while(first.obj.equals(obj)){
			first = first.next;
		}
		Data pre = first;
		Data cur = first.next;
		while(cur!=null){
			if(cur.obj.equals(obj)){
				pre.next = cur.next;
				pre = pre.next;
				cur = pre.next;  //此时的pre.next跟上一行又不是一回事
				continue;   //跳过下面的迭代，继续下一次循环
			}
			pre = cur;
			cur = cur.next;
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
}
