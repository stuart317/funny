package com.synchronzied.sync01;

/**
 * 测试  方法内   不存在“非线程安全”
 */
public class TestHum {

    private int num = 0; //方法外变量，存在线程安全问题 ， 解决：方法前加 synchronized

    public void addId(String username){

        try {
            //int num = 0;  //变量定义在方法内，不会有"非线程安全"，因为方法内私有变量特性
            if("a".equals(username)){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else{
                num = 300;
                System.out.println("b set over!");
            }
            System.out.println(">>>>>>username="+username+"  num="+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
