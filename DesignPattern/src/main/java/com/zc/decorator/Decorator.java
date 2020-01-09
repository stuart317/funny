package com.zc.decorator;

/**
 *  装饰模式(Decorator Pattern)：
 *      动态地给一个对象增加一些额外的职责，就增加对象功能来说， 装饰模式比生成子类实现更为灵活。
 *
 * 使用场景：
 *      替代继承，扩展一个类的功能
 *      动态的给一个对象添加功能，以及动态的撤销该功能
 *
 * 优点：
 *      动态扩展一个实现类的功能，在不需要添加功能的时候，可以撤销装饰。
 *      装饰类和被装饰类模块间，通过抽象产生依赖，不会相互耦合
 *      装饰模式替换继承，可以避免继承链的子类被影响
 *
 *
 *
 * 装饰模式与代理模式的区别：
 *      装饰模式：侧重给一个实现类动态添加功能，不会对实现类的方法进行过滤拦截
 *
 *      代理模式：侧重将一个实现类的功能，委托给代理类来处理，可以对实现类的方法进行过滤拦截(某种情况下，
 *               可能不执行实现类的方法)
 */

/**
 *  装饰者  抽象类
 */
public abstract class Decorator implements Human{

    //持有被装饰类的引用
    private Human human;

    public Decorator(Human human){
        this.human = human;
    }

    @Override
    public void run() {
        human.run();  //调用 被装饰类 方法
    }

}
