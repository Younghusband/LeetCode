package com.playground.cache;

/**
 * 用数组写了一个
 * 
 * 数组顺序插入， 坐标越远则表示元素越新
 * 
 * 每次检查元素是否存在的时候都需要遍历数组，尝试过用map存储数组元素对应的下标，但这样平移数组的时候需要同时维护map中的值，更麻烦
 */

public class HandMakeCache {
	//添加次数 计数器
    static int count =0;
    //数组元素 计数器
    static int size=0;
    
	//最大长度
	int maxSize;
	//对象数组
	int [] listArray;  //为了简略比较
	
	//顺序表的初始化方法
	public HandMakeCache(int maxSize)
	{
		listArray = new int [maxSize];
		this.maxSize = maxSize;
	}
	
	public int getSize(){
		return size;
	}

	public void insert(int obj) throws Exception {
		// 插入过程不应该指定下标，对于用户来讲这应该是透明的，只需要暴露插入的顺序
		boolean exist = false; // 每次insert校验一下是否存在
		int location = -1; // 对于已有元素，记录其已存在的位置
		for (int i=0; i<size; i++) {
		    if(obj == listArray[i]) {
		        exist = true;
		    }
		    location = i;
		}
		if (size < this.maxSize) { // 当插入次数小于缓存大小的时候随意插入
			if (exist) {
				if (location < size - 1) { // 插入的元素  原本不在最新的位置上
				    moveArrayElements(listArray, location , size-2);
				}
				listArray[size - 1] = obj; 
			} else {
				listArray[size] = obj;
				size++; // 数组未满时才计数
			}
		} else { // 此时缓存为满，这时候要保留最末端元素先
			if (!exist || obj == listArray[0]) { // 新元素添加进来，和最旧元素添加进来效果一样
				moveArrayElements(listArray, 0, maxSize-2);
			} else if (obj != listArray[maxSize - 1]) {
				moveArrayElements(listArray, location, maxSize-2);
			} // 如果添加的是上次添加的元素，则不管了。。
			listArray[maxSize - 1] = obj;
		}
		count++; // 计数
	}
	
	
	/**
	 * 缓存获值方法
	 */
	public Object get(int index) throws Exception {
		return listArray[size-index-1];  // 让其逆序输出
	}
	
	/**
	 * 平移数组的方法，start是要移动至的头位置，end为最后被移动的位置。
	 * */
	public void moveArrayElements(int [] arr, int start, int end) {
		for(int i=start; i<=end; i++){
			arr[i] = arr[i+1];
		}
	}
	
	
	
	public static void main(String[] args) {
		int cacheSize = 3;
		HandMakeCache list = new HandMakeCache(cacheSize);
        try
        {
        	list.insert(1);
        	list.insert(2);
        	list.insert(3);
        	list.insert(1);
//        	list.insert(3);
//        	list.insert(4);
//        	list.insert(4);
//        	list.insert(5);
//        	list.insert(3);
        	for(int i=0;i<cacheSize;i++) {
        		System.out.println(list.get(i));
        	}
        	System.out.println("成功插入"+count+"次元素.");
        	
        } catch(Exception ex) {

        }
        
	}
}
