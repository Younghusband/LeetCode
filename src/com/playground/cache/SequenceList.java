package com.playground.cache;


/**
 * 受龙哥启发，用数组写了一个
 * 
 * */

public class SequenceList {
	   //计数器
	    static int count =0;
		//最大长度
		int maxSize;
		//对象数组
		int [] listArray;  //为了简略比较
		
		//顺序表的初始化方法
		private SequenceList(int maxSize)
		{
			listArray = new int [maxSize];
			this.maxSize = maxSize;
		}

	public void insert(int obj) throws Exception {
		// 插入过程不应该指定下标，对于用户来讲这应该是透明的，只需要暴露插入的顺序
		boolean exist = false; // 每次insert校验一下是否存在
		int location = 0;  //对于已有元素，记录其已存在的位置
		if (count < this.maxSize) { // 当插入次数小于缓存大小的时候随意插入
			listArray[count] = obj;
		} else { // 此时缓存为满，这时候要保留最末端元素先
			int last = listArray[maxSize - 1];
			for (int i = 0; i < maxSize; i++) {
				if (obj == listArray[i]){
					exist = true;
					location = i;  //记录已存在的位置
				}
			} // 遍历看是否已有
			if (!exist) {
				for (int x = 0; x < maxSize - 2; x++) {
					listArray[x] = listArray[x + 1];
				}
				listArray[maxSize - 2] = last;
			}else{
				if (obj == listArray[0]) { // 此时倒数第二位至第二位元素整体前移
					for (int x = 0; x < maxSize - 2; x++) {
						listArray[x] = listArray[x + 1];
					}
					listArray[maxSize - 2] = last;
				} else if (obj == listArray[maxSize - 1]) {  //如果插入的是最新的元素，什么也不用做
					// doNothing...
				} else {
                      for(int i=location;i<maxSize-2;i++){  //注意这里用的location
                    	  listArray[i] = listArray[i+1];
                      }
					  listArray[maxSize - 2] = last;
				}

			}
		}
		listArray[maxSize - 1] = obj; 
        count++;  //计数
	}
		
		public Object get(int index) throws Exception {
			return listArray[index];
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int cacheSize = 4;
			
	        SequenceList list = new SequenceList(cacheSize);
	        try
	        {
	        	list.insert(1);
	        	list.insert(2);
	        	list.insert(3);
	        	list.insert(4);
	        	list.insert(5);
	        	list.insert(3);
	        	
	        	for(int i=0;i<cacheSize;i++)
	        	{
	        		System.out.println(list.get(i));
	        	}
	        	System.out.println("插入了"+count+"次元素.");
	        	
	        }
	        catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        }
	        
		}
		
}
