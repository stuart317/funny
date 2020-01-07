package com.thread;


/**
 *  测试线程 随机性
 */
public class ThreadRandom extends Thread{

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(" run= "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        try {
            ThreadRandom threadRandom = new ThreadRandom();
            threadRandom.setName("myThrad >>>>> ");

            /**
             * start()方法 通知"线程规划器"，此线程已准备就绪，等待调用线程对象的run()方法，具有异步执行效果
             *
             * 如果代码调用 threadRandom.run() ,就直接由main主线程来调用run(), 是同步
             */
            threadRandom.start();

            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(" main= "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}