package com.zc.factory.factory;

/**
 * 工厂方法模式(Factory Method Pattern)：
 *
 *    定义一个用于创建对象的接口，让子类决定将哪一个 类实例化。工厂方法模式让一个类的实例化延迟到其子类。
 *    工厂方法模式又简称为工厂模式 (Factory Pattern)，又可称作虚拟构造器模式(Virtual Constructor Pattern)
 *    或多态工厂模式 (Polymorphic Factory Pattern)。工厂方法模式是一种类创建型模式。
 */
abstract class Factory {

    //在工厂类中直接调用 产品类的业务方法say()
    /**
     * 对客户端隐藏工厂方法，此时，在工厂类中 将直接调用产品类的业务方法，客户端无须调用工厂方法创建产品，
     * 直接通过工厂即可使用 所创建的对象中的业务方法。
     */
    public void say() {
        Product product = this.factoryMethod();
        product.say();
    }

    //工厂抽奖方法
    abstract  Product factoryMethod();
}

/**
 * 香蕉工厂
 */
class BananaFactory extends Factory{
    @Override
    public Product factoryMethod() {
        return new Banana();
    }
}

/**
 * 苹果工厂
 */
class AppleFactory extends Factory{
    @Override
    public Product factoryMethod() {
        return new Apple();
    }
}


class Client {
    public static void main(String[] args) throws Exception {
        /**
         * 一，直接调用对应产品工厂
         */
        /*Factory factory = new BananaFactory();
        Product product = factory.factoryMethod();
        product.say();*/

        /**
         * 二、读取配置文件，利用java反射生成对象
         */
        /*Factory factoryxml = (Factory) XMLUtil.getBean();
        Product productxml = factoryxml.factoryMethod();
        productxml.say();*/

        /**
         * 三、对客户端隐藏工厂方法，此时，在工厂类中 将直接调用产品类的业务方法，客户端无须调用工厂方法创建产品，
         *    直接通过工厂即可使用 所创建的对象中的业务方法。
         */
        Factory factoryK = (Factory) XMLUtil.getBean();
        factoryK.say();
    }
}