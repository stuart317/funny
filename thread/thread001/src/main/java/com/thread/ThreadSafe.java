package com.thread;

/**
 * 实例变量 与 线程安全
 * （变量不共享）
 */
public class ThreadSafe extends Thread {

    private int count = 5;

    public ThreadSafe(String name){
        super();
        this.setName(name); //设置线程名称
    }

    @Override
    public void run(){
        //super.run();
        while (count > 0){
            count --;
            System.out.println("由 ="+this.currentThread().getName()+" 计算，count="+count);
        }
    }


    public static void main(String[] args) {

        /**
         *  变量不共享， 每个线程  独立有自己的count
         */
        ThreadSafe t1 = new ThreadSafe("A");
        ThreadSafe t2 = new ThreadSafe("B");
        ThreadSafe t3 = new ThreadSafe("C");
        t1.start();
        t2.start();
        t3.start();
    }

}


