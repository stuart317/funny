package com.method;

/**
 * 测试 sleep方法
 */
public class MyThread001 extends Thread {

    @Override
    public void run(){
        try {
            System.out.println("run threadName="+this.currentThread().getName()+ " === begin ");
            Thread.sleep(2000);
            System.out.println("run threadName="+this.currentThread().getName()+ " === end ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        MyThread001 myThread001 = new MyThread001();
        System.out.println("begin======="+System.currentTimeMillis());
        myThread001.start();
        System.out.println("end======="+System.currentTimeMillis());
        System.out.println("线程唯一标识："+myThread001.getId());
    }
}
