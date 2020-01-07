package com.zc.factory.abstractfactory;

import com.zc.factory.abstractfactory.factory.SkinFactory;
import com.zc.factory.abstractfactory.factory.SummerSkinFactory;
import com.zc.factory.abstractfactory.product.Button;
import com.zc.factory.abstractfactory.product.ComBox;
import com.zc.factory.abstractfactory.product.TextField;

/**
 * 抽象工厂测试
 *
 * 抽象工厂模式(Abstract Factory Pattern)：
 *      提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。
 *      抽象工厂模式又称为Kit模式，它是一种对象创建型模式。
 *
 *
 *   在抽象工厂模式中，每一个具体工厂都提供了多个工厂方法用于产生多种不同类型的产品， 这些产品构成了一个产品族
 */
public class Test {

    /**
     * 1. 主要优点 抽象工厂模式的主要优点如下：
     *     (1) 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离， 更换一个具体
     *         工厂就变得相对容易，所有的具体工厂都实现了抽象工厂中定义的那些公共接 口，因此只需改变具体
     *         工厂的实例，就可以在某种程度上改变整个软件系统的行为。
     *     (2) 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产 品族中的对象。
     *     (3) 增加新的产品族很方便，无须修改已有系统，符合“开闭原则”。
     *
     * 2. 主要缺点 抽象工厂模式的主要缺点如下：
     *      增加新的产品等级结构麻烦，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，
     *      这显然会带来较大的不便，违背了“开闭原则”。
     */
    public static void main(String[] args) {

        /**
         * 为了让系统具备良好的灵活性和可扩展性，可以引入了配置文件，配置具体工厂实例
         */
        //抽象工厂
        //SkinFactory skinFactory = new SpringSkinFactory(); //具体工厂
        SkinFactory skinFactory = new SummerSkinFactory(); //具体工厂
        //创建按钮
        Button button = skinFactory.createButton();
        //创建文本框
        TextField textField = skinFactory.createTextField();
        //创建复选框
        ComBox comBox = skinFactory.createComBox();

        button.display();
        textField.display();
        comBox.display();
    }
}
