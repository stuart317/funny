package com.zc.singleton;

/**
 *
 * 确保对象的唯一性——单例模式
 *
 * IoDH 单例
 *
 *
 * 饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；懒汉式单例类线程安全控 制烦琐，而且性能受影响。
 * 可见，无论是饿汉式单例还是懒汉式单例都存在这样那样的问题。
 * 解决方案： Initialization Demand Holder (IoDH)技术。
 *
 * 在IoDH中，我们在单例类中增加一个静态(static)内部类，在该内部类中创建单例对象，
 * 再将该单例对象通过getInstance()方法返回给外部使用
 *
 */
public class IoDH {

    private IoDH(){}

    /**
     * 静态内部类
     */
    private static class HolderClass {
        private final static IoDH instance = new IoDH();
    }

    public static IoDH getInstance() {
        return HolderClass.instance;
    }

    /**
     * 总结:
     *
     *  由于静态单例对象没有作为 IoDH 的成员变量直接实例化，因此类加载时不会实例化 IoDH，
     *  第一次调用getInstance()时将加载内部类HolderClass， 在该内部类中定义了一个static类型的变量 instance，
     *  此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。
     *  由于getInstance()方法没有任何线程锁定，因此其性能不会造成任何影响。通过使用IoDH，我们既可以实现延迟加载，
     *  又可以保证线程安全，不影响系统性能，不失为一种最好的Java语言单例模式实现方式
     *  （其缺点是与编程语言本身的特性相关，很多面向对象语言不支持IoDH）。
     */

    //测试
    public static void main(String[] args) {
        IoDH s1, s2;
        s1 = IoDH.getInstance();
        s2 = IoDH.getInstance();
        System.out.println("实例是否相同:"+(s1==s2));
    }
}

