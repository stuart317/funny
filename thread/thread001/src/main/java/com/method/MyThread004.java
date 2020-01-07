package com.method;

/**
 * 暂停线程
 * <p>
 * suspend 暂停线程
 * resume  恢复线程
 */
public class MyThread004 extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }
    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }


    public static void main(String[] args) {

        try {
            MyThread004 myThread004 = new MyThread004();
            myThread004.start();
            Thread.sleep(5000);

            //A段
            myThread004.suspend();//暂停线程
            System.out.println("A ===== "+System.currentTimeMillis()+" i="+myThread004.getI());
            Thread.sleep(5000);
            System.out.println("A ===== "+System.currentTimeMillis()+" i="+myThread004.getI());

            //B
            myThread004.resume();//恢复线程
            Thread.sleep(5000);

            //C
            System.out.println("C ===== "+System.currentTimeMillis()+" i="+myThread004.getI());
            Thread.sleep(5000);
            System.out.println("C ===== "+System.currentTimeMillis()+" i="+myThread004.getI());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
