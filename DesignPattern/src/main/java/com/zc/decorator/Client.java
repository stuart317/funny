package com.zc.decorator;

/**
 * 客户端测试
 *
 * 扩展系统功能——装饰模式
 */
public class Client {
    public static void main(String[] args) {

        //创建被装饰的类
        Human human = new Man();

        //创建装饰的类，并添加被装饰类的引用
        Human superMan = new DecoratorImpl(human);
        //可以将装饰了一次之后的对象继续注入到另一个装饰类
        //Human superMan2 = new OrtherDecoratorImpl(superMan); //还未定义

        //执行增强后的run方法
        superMan.run();

        /**
         *  拓展：
         *
         *  我们可以将装饰了一次之后的 superMan1 对象注入另一个装饰类【同一父装饰者】中实现第二次装饰，
         *  得到一个经过两次装饰的对象 superMan2，再调用superMan2 的display()方 法即可得到一个
         *  有多功能的方法。
         */
    }
}
