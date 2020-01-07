package com.method;

/**
 * 能停止的线程   -- 异常法
 *
 *
 * 建议使用抛异常的方式 终止线程 , 因为catch可以将 异常向上抛
 */
public class MyThread003 extends Thread{

    @Override
    public void run(){
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if(this.isInterrupted()){
                    System.out.println("========停止了");
                    //break;
                    //return;//使用 return + Interrupt 来停止线程
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }
            System.out.println("我在 for下面");
        } catch (InterruptedException e) {
            System.out.println("进入MyThread003类run方法中的 catch中了");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            MyThread003 myThread003 = new MyThread003();
            myThread003.start();
            Thread.sleep(1000);
            myThread003.interrupt(); //终止线程  ， 并不能立即终止
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
