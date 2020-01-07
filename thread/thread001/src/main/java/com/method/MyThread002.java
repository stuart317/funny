package com.method;

/**
 * 停止线程方法
 *
 * 推荐使用 interrupt ，不推荐使用stop（有问题）
 */
public class MyThread002 extends Thread{

    @Override
    public void run(){
       super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i="+(i+1));
        }
    }

    public static void main(String[] args) throws Exception{

        MyThread002 myThread002 = new MyThread002();
        myThread002.start();
        Thread.sleep(1000);
        myThread002.interrupt(); //终止线程  ， 并不能立即终止
//        System.out.println("是否终止1："+myThread002.interrupted()); //测试当前线程是否已中断 , 执行后具有将状态标志置为false的功能
//        System.out.println("是否终止2："+myThread002.interrupted());
        System.out.println("是否终止1："+myThread002.isInterrupted()); //测试线程是否已中断,但不清楚状态
        System.out.println("是否终止2："+myThread002.isInterrupted());
    }
}


class Test001{

    public static void main(String[] args) {

        Thread.currentThread().interrupt();
        System.out.println("是否终止1："+Thread.interrupted()); //测试当前线程是否已中断 , 执行后具有将状态标志置为false的功能
        System.out.println("是否终止2："+Thread.interrupted());
        System.out.println("end!");

        /**
         * interrupted() 具有清除状态的功能
         *
         * 输出：
         *      是否终止1：true
         *      是否终止2：false
         *      end!
         *  如果连续调用两次，第二次将会返回 fase
         */
    }
}