package com.example;

import com.thread.ThreadSafe2;

/**
 *  i-- 与 println()联合使用 出现异常
 */
public class SameNum extends Thread{

    private int i = 5;

    @Override
    synchronized public void run(){
        /**
         * 虽然println()方法在内部是同步的，但i--操作却是进入println()之前发生的，存在发生非线程安全的概率
         *
         * 所以还是要加入 synchronized
         */
        System.out.println("i="+(i--)+"  threadName="+this.currentThread().getName());
    }




    public static void main(String[] args) {

        SameNum sameNum = new SameNum();
        Thread t1 = new Thread(sameNum);
        Thread t2 = new Thread(sameNum);
        Thread t3 = new Thread(sameNum);
        Thread t4 = new Thread(sameNum);
        Thread t5 = new Thread(sameNum);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
