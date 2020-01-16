package com.zc.flyweight;

/**
 * 定义具体享元类
 *
 * ● ConcreteFlyweight（具体享元类）：它实现了抽象享元类，其实例称为享元对象；在具体享元类中为内部
 *  *      状态提供了存储空间。通常我们可以结合单例模式来设计具体享元类，为每一个具体享元类提供唯一的享元对象。
 */
public class ConcreteBook implements Book {

    //被借阅的署名
    private String name;

    public ConcreteBook(String name){
        this.name = name;
    }

    @Override
    public void borrow() {
        System.out.println("被借阅的书名为："+this.name);
    }
}
