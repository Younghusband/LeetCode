package com.playground.jvm;

/**
 * @program: LeetCode
 * @description: test finalize()
 * @author: Vermouth
 * @create: 2019-06-04 22:58
 **/


public class TestFinalize {

    public static TestFinalize obj;

    //当执行GC时，会执行finalize方法，并且只会执行一次
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj = this;   //当执行GC时，会执行finalize方法，然后这一行代码的作用是将null的object复活一下，然后变成了可触及性
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    public static void main(String[] args) throws
            InterruptedException {
        obj = new TestFinalize();
        obj = null;   //可复活
        System.out.println("第一次gc");
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj 是 null");
        } else {
            System.out.println("obj 可用");
        }
        obj = null;    //不可复活
        System.out.println("第二次gc");
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj 是 null");
        } else {
            System.out.println("obj 可用");
        }
    }
}