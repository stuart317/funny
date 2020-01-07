package com.thread;

public class MyThread  extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread run ----"+this.isAlive());
    }


    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        System.out.println("begin ==== "+myThread.isAlive()); //判断线程是否 活着
        myThread.start();
        System.out.println("运行结束");   //线程随机性 ，运行结果与代码执行顺序、调用顺序无关
        System.out.println("end ==== "+myThread.isAlive());
    }
}
