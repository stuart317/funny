package com.thread;

public class ThreadZ extends Thread{

    private int i;

    public ThreadZ(int i){
        super();
        this.i = i;
    }

    @Override
    public void run(){
        System.out.println(i);
    }


    public static void main(String[] args) {

        /**
         * 多执行几次，就会打印结果不同
         *
         * 执行start()的顺序不代表程序启动的顺序。
         */

        ThreadZ t1 = new ThreadZ(1);
        ThreadZ t2 = new ThreadZ(2);
        ThreadZ t3 = new ThreadZ(3);
        ThreadZ t4 = new ThreadZ(4);
        ThreadZ t5 = new ThreadZ(5);
        ThreadZ t6 = new ThreadZ(6);
        ThreadZ t7 = new ThreadZ(7);
        ThreadZ t8 = new ThreadZ(8);
        ThreadZ t9 = new ThreadZ(9);
        ThreadZ t10 = new ThreadZ(10);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();


    }
}
