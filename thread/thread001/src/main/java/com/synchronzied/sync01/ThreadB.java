package com.synchronzied.sync01;

/**
 * 测试 方法内  不存在“非线程安全”
 */
public class ThreadB extends Thread{

    private TestHum testHum;

    public ThreadB(TestHum testHum){
        super();
        this.testHum = testHum;
    }

    @Override
    public void run(){
        testHum.addId("b");
    }

}


class Run01{

    public static void main(String[] args) {
        TestHum testHum = new TestHum();
        ThreadA threadA = new ThreadA(testHum);
        threadA.start();
        ThreadB threadB = new ThreadB(testHum);
        threadB.start();
    }
}