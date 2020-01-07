package com.zc.prototype;

/**
 * 原型模式
 *
 * 原型模式(Prototype Pattern)：
 *
 *      使用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。原型模式是一种对象创建型模式。
 */
public interface Prototype {
    /**
     * Java语言提供的clone()方法
     *  学过Java语言的人都知道，所有的Java类都继承自java.lang.Object。事实上，Object类提供一个 clone()方法，
     *  可以将一个Java对象复制一份。因此在Java中可以直接使用Object提供的clone()方 法来实现对象的克隆，
     *  Java语言中的原型模式实现很简单。 需要注意的是能够实现克隆的Java类必须实现一个标识接口Cloneable，
     *  表示这个Java类支持被 复制。如果一个类没有实现这个接口但是调用了clone()方法，
     *  Java编译器将抛出一个 CloneNotSupportedException异常。
     */
}

class ConcretePrototype implements Prototype{

    private String attr; //成员属性

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Prototype clone(){ //克隆方法
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAttr("你好明天");
        return concretePrototype;
    }
}
