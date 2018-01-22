package designpattern;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午9:14:34
 * 
 * 
 * 用枚举写单例实在太简单了！这也是它最大的优点。下面这段代码就是声明枚举实例的通常做法。
   我们可以通过EasySingleton.INSTANCE来访问实例，
   这比调用getInstance()方法简单多了。创建枚举默认就是线程安全的，所以不需要担心double checked locking，
   而且还能防止反序列化导致重新创建新的对象。但是还是很少看到有人这样写，可能是因为不太熟悉吧。
 * 
 * 
 */

     public enum EasySingleton {
         INSTANCE;      //然而枚举究竟是什么，怎么用呢。。。
    }
