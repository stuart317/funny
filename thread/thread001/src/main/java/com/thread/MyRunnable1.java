package com.thread;


/**
 * 实现 runnable接口
 */
public class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        System.out.println(" runnable 正在运行中 。。。");
    }

    public static void main(String[] args) {

        MyRunnable1 myRunnable1 = new MyRunnable1();

        Thread thread = new Thread(myRunnable1); //使用 Thread构造传参 , 实现异步加载
        thread.start();
        System.out.println("运行结束。。。");
    }
}
