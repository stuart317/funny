package com.synchronzied.sync01;

/**
 * 测试 方法内  不存在“非线程安全”
 */
public class ThreadA extends Thread{

    private TestHum testHum;

    public ThreadA(TestHum testHum){
        super();
        this.testHum = testHum;
    }

    @Override
    public void run(){
        testHum.addId("a");
    }

}
