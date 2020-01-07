package com.zc.singleton;

/**
 * 枚举单例
 *
 * 单元素的枚举类型已经成为实现Singleton的最佳方法。
 *
 *
 * 总结:
 *   之前三种实现单例的方式都有共同的缺点：
 *      1）需要额外的工作来实现序列化，否则每次反序列化一个序列化的对象时都会创建一个新的实例。
 *      2）可以使用反射强行调用私有构造器（如果要避免这种情况，可以修改构造器，让它在创建第二个实例的时候抛异常）。
 *
 *  而枚举类很好的解决了这两个问题，使用枚举除了线程安全和防止反射调用构造器之外，还提供了自动序列化机制，
 *  防止反序列化的时候创建新的对象。
 */
public class EnumSingleton {

    //私有构造方法
    private EnumSingleton(){}

    //提供公有获取实例方法
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    //静态内部类
    private static enum Singleton{
        INSTANCE;
        private EnumSingleton singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return singleton;
        }
    }
}

/**
 * 测试
 */
class Test{
    public static void main(String[] args) {
        EnumSingleton obj1 = EnumSingleton.getInstance();
        EnumSingleton obj2 = EnumSingleton.getInstance();
        //输出结果：obj1==obj2?true
        System.out.println("obj1==obj2?" + (obj1==obj2));

    }
}
