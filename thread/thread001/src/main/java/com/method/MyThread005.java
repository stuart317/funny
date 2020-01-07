package com.method;

/**
 * 线程  优先级
 *
 *  ① 优先级 有继承特性
 *  ② 优先级 有规则性
 */
public class MyThread005 extends Thread{

    @Override
    public void run() {
        System.out.println("优先级："+this.getPriority());
        long a = System.currentTimeMillis();

        long b = System.currentTimeMillis();

    }


    public static void main(String[] args) {

        MyThread005 myThread005 = new MyThread005();
        myThread005.start();
        myThread005.setPriority(Thread.MAX_PRIORITY);//优先级10

    }
}
