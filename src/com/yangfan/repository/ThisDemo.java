package com.yangfan.repository;
/************************************************
    * Description: 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月13日 下午12:45:30 
**************************************************/
public class ThisDemo {  
	
    //////-----------------------------------------------------
//    String name;
//    int age;
//    public ThisDemo (){ 
//        this.age=21;
//   }     
//    public ThisDemo(String name,int age){
//        this();
//        this.name="Mick";
//    }     
//  private void print(){
//         System.out.println("最终名字="+this.name);
//         System.out.println("最终的年龄="+this.age);
//    }
//    public static void main(String[] args) {
//       ThisDemo tt=new ThisDemo("",0); //随便传进去的参数
//       tt.print();
//    }
    
    //////-----------------------------------------------------
    
    String name;
    int age;
    public ThisDemo (){ 
        this.age=21;
   }     
    public ThisDemo(String name,int age){
        this();
        this.name="Mick";
    }     
  private void print(){
         System.out.println("最终名字="+this.name);
         System.out.println("最终的年龄="+this.age);
    }
    public static void main(String[] args) {
       ThisDemo tt=new ThisDemo("",0); //随便传进去的参数  毕竟毫无用处
       tt.print();
    }
    
    
    
    
}