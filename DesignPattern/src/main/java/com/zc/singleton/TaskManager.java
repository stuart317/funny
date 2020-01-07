package com.zc.singleton;

/**
 * 单例模式  --懒汉式   延迟加载
 *
 * 单例模式有三个要点：
 *      一是某个类只能有一个实例；
 *      二是它必须自行创建这个实例；
 *      三是它 必须自行向整个系统提供这个实例。
 *
 *
 * 懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自 行实例化，
 * 这种技术又称为延迟加载(Lazy Load)技术，即需要的时候再加载实例
 *
 */
public class TaskManager {

    //将构造方法私有化
    private TaskManager(){ }

    /**
     *  需要注意的是，如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
     *  被volatile修饰的成员变量可以确保多个线程都能够正确处理，
     *  且该代 码只能在JDK 1.5及以上版本中才能正确执行。由于volatile关键字会屏蔽Java虚拟机所做的一 些代码优化，
     *  可能会导致系统运行效率降低，因此即使使用双重检查锁定来实现单例模式也 不是一种完美的实现方式。
     */
    private volatile static TaskManager taskManager = null;

    /**
     *  线程锁，处理多个线程同时访问的问题
     */
    public static TaskManager getInstance(){
        /**
         * 为双重检查锁定
         */
        //第一重判断
        if(taskManager == null){
            //锁定代码块
            synchronized (TaskManager.class){ //类锁
                //第二重判断
                if(taskManager == null){
                    taskManager = new TaskManager();
                }
            }
        }
        return taskManager;
    }
}
