package com.problems.code.easy;
/************************************************
    * Description: 
    *  Given two binary trees, write a function to check if they are equal or not.
       Two binary trees are considered equal if they are structurally identical and 
       the nodes have the same value. 
       
       Depth-first Search
    * 
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月8日 上午11:34:02 
**************************************************/
public class Same_Tree {
      public static void main(String[] args) {
		
	}
      
      public boolean isSameTree(TreeNode p, TreeNode q) {
    	        if(p == null || q == null) return p==q;  
    	        if(p.val == q.val)
    	          return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    	        return false;
      }
      
}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
