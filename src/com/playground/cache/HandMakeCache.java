package com.playground.cache;


/**
 * 用数组写了一个
 * 
 * 有个疑问， 比如当缓存大小为5  这时候1、2、3、4、4  请问最后一个4是应该插入还是不处理呢？ 
 * 
 * 我个人觉得如果这里理解为缓存的key ，那么就应该是不插入  结果应该还是1、2、3、4、null 
 * 
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
	private HandMakeCache(int maxSize)
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
		int location = 0; // 对于已有元素，记录其已存在的位置
		for (int i = 0; i < maxSize; i++) {
			if (obj == listArray[i]) {
				exist = true;
				location = i; // 记录已存在的位置
			}
		} // 遍历看是否已有，每次插入都要遍历，感觉性能很差
		if (size < this.maxSize) { // 当插入次数小于缓存大小的时候随意插入
			if (exist) {
				if (location == 0) {
					for (int x = 0; x < size - 1; x++) {
						listArray[x] = listArray[x + 1];
					}
				} else if (location < size - 1) { // 已存在元素不在最新的位置
					for (int x = location; x < size - 1; x++) {
						listArray[x] = listArray[x + 1];
					}
				}
				listArray[size - 1] = obj; // 由于已存在
			} else {
				listArray[size] = obj;
				size++; // 数组未满时才计数
			}
		} else { // 此时缓存为满，这时候要保留最末端元素先
			if (!exist || obj == listArray[0]) { // 新元素添加进来，和最远元素添加进来效果一样
				for (int x = 0; x <= maxSize - 2; x++) {
					listArray[x] = listArray[x + 1];
				}
			} else if (obj != listArray[maxSize - 1]) {
				for (int i = location; i <= maxSize - 2; i++) { // 注意这里用的location
					listArray[i] = listArray[i + 1];
				}
			} // 如果添加的是上次添加的元素，则不管了。。
			listArray[maxSize - 1] = obj;
		}
		count++; // 计数
	}
	
	public Object get(int index) throws Exception {
		return listArray[index];
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 5;
		HandMakeCache list = new HandMakeCache(cacheSize);
        try
        {
        	list.insert(1);
        	list.insert(2);
        	list.insert(3);
        	
        	list.insert(1);
        	
        	list.insert(3);
        	list.insert(4);
        	list.insert(4);
        	list.insert(5);
        	list.insert(3);
        	
        	for(int i=0;i<cacheSize;i++)
        	{
        		System.out.println(list.get(i));
        	}
        	System.out.println("成功插入"+count+"次元素.");
        	
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        
	}
}
