package com.thread;

/**
 * 变量共享
 */
public class ThreadSafe2 extends Thread {

    private int count = 7;

/*
    会有线程 安全问题
    @Override
    public void run(){
        //super.run();
        *//**
         * 此处 不用for循环，因为使用同步后，其他线程就得不到运行的机会了
         * 一直由一个线程进行减法
         *//*
        count --;
        System.out.println("由 ="+this.currentThread().getName()+" 计算，count="+count);
    }*/

    /**
     * 加入 synchronized 是多个线程在执行run方法时，以排队方式进行处理
     */
    @Override
    synchronized public void run(){
        count --;
        System.out.println("由 ="+this.currentThread().getName()+" 计算，count="+count);
    }


    public static void main(String[] args) {

        /**
         *  变量共享，多线程同时访问一个 变量
         */
        ThreadSafe2 threadSafe2 = new ThreadSafe2();
        Thread t1 = new Thread(threadSafe2,"A");
        Thread t2 = new Thread(threadSafe2,"B");
        Thread t3 = new Thread(threadSafe2,"C");
        Thread t4 = new Thread(threadSafe2,"D");
        Thread t5 = new Thread(threadSafe2,"E");
        Thread t6 = new Thread(threadSafe2,"F");
        Thread t7 = new Thread(threadSafe2,"G");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        /**
         * 结果示例：
         *
         * 由 =A 计算，count=5
         * 由 =B 计算，count=5
         * 由 =C 计算，count=4
         * 由 =D 计算，count=3
         * 由 =E 计算，count=2
         * 由 =F 计算，count=1
         * 由 =G 计算，count=0
         *
         *
         * 说明 A 和B 同时对count进行处理，产生了“ 非线程安全”问题
         */
    }

}


