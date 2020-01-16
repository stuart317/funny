package com.zc.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 *  ● FlyweightFactory（享元工厂类）：享元工厂类用于创建并管理享元对象，它针对抽象享元 类编程，将各种
 *        类型的具体享元对象存储在一个享元池中，享元池一般设计为一个存储“键值 对”的集合（也可以是其他类型的集
 *        合），可以结合工厂模式进行设计；当用户请求一个具体 享元对象时，享元工厂提供一个存储在享元池中已
 *        创建的实例或者创建一个新的实例（如果 不存在的话），返回新创建的实例并将其存储在享元池中。
 */
public class Library {

    //定义共享池
    private Map<String,Object> pool = new HashMap<>();

    //单例模式，获取当前工厂
    private static Library library = new Library();

    private Library() {}

    public static Library getInstance(){
        return library;
    }

    //图书馆外借图书
    public Book libToBorrow(String name){
        Book book;
        if(pool.containsKey(name)){
            //从共享池取书
            book = (Book) pool.get(name);
        } else {
            //创建新书
            book = new ConcreteBook(name);
            pool.put(name,book); //新书存进去
        }
        return book;
    }

    //返回图书馆书架上 书的数量
    public int getBookSize(){
        return pool.size();
    }

}
