package com.problems.code.medium;

/**
 * @author mr_yo
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
   Explanation: 342 + 465 = 807.
 * 
 */
public class Add_Two_Numbers {

    public static void main(String[] args) {
        Add_Two_Numbers a = new Add_Two_Numbers();
        ListNode l1 = new ListNode(2);
        l1.add(4).add(3);
        
        ListNode l2 = new ListNode(5);
        l2.add(6).add(4);
        
        
//        ListNode head = l1;
//        System.out.println(head.next.next.val);
//        System.out.println(head.val);
        
//        l1.print();
        
        ListNode result =  a.addTwoNumbers(l1, l2);
        System.out.println(result.val+","+result.next.val+","+result.next.next.val);
                
    }

    
    
    
    /**
     * 本人愚钝，这是我第一次想出来的方法。。  
     * 效率比较低，判断比较繁琐
     * But result is 'Your runtime beats 98.57% of java submissions.'
     * 
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode resultHead = l;
        
        int temp = 0;                      //存放上次进位
        while (l1 != null || l2 != null) { //both two lists have next node
           int a = l1 == null ? 0 : l1.val;
           int b = l2 == null ? 0 : l2.val;
           int sum = a + b + temp;
           int newNum = sum >=10 ? sum-10 : sum;
           temp = sum >=10 ? 1:0;
           resultHead.val = newNum; 
           
            if (l1 == null || l2 == null) {   // 当l1或l2某一条到头了才会进来
                if (l1 != null) {
                    if (l1.next == null && temp == 0) {
                        break;
                    }
                } else { // l2 not to the end
                    if (l2.next == null && temp == 0) {
                        break;
                    }
                }
            }
            
            if(l1 != null && l2 != null && (l1.next == null && l2.next ==null)) {  // 前面两个!=null 是阻止后面出现空指针异常所必备的
                if(temp == 1) {
                    resultHead.next = new ListNode(temp);
                    resultHead = resultHead.next;
                }
                break;
            }
           resultHead.next = new ListNode(temp);  // 给下一个元素赋初始值
           resultHead = resultHead.next;   
           
           if(l1 != null)
               l1 = l1.next;
           if(l2 != null)
               l2 = l2.next;
        }
        return l;
    }
    
        

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    
    /**
     * 提供一个 listNode的追加方法，返回追加后的链表头~
     * 链表追加新元素的方法是非常经典的东西，不能忘哦
     */
    public ListNode add(int val) {
        ListNode newNode = new ListNode(val);
        ListNode head = this;    
        ListNode tail = this.next;
        while(tail!=null) {
            tail = tail.next;
            head = head.next;
        }
        tail = newNode;
        head.next = tail;
        return this;
    }
    
    public void print() {
        System.out.println("oooooo");
    }
    
}





