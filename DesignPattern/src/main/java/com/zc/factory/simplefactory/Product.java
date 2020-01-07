package com.zc.factory.simplefactory;

/**
 * 简单工厂模式(Simple Factory Pattern)：
 *     定义一个工厂类，它可以根据参数的不同返回不同类的 实例，被创建的实例通常都具有共同的父类。
 * 因为在简单工厂模式中用于创建实例的方法是 静态(static)方法，因此简单工厂模式又被称为静态
 * 工厂方法(Static Factory Method)模式，它属 于类创建型模式。
 */
interface Product {
    //声明抽象业务方法
    void display();
}

class Banana implements Product{
    @Override
    public void display() {
        System.out.println("我是香蕉");
    }
}
class Apple implements Product{
    @Override
    public void display() {
        System.out.println("我是苹果");
    }
}

/**产品工厂***/
class ProductFactory{

    //静态工厂
    public static Product getProduct(String type){
        Product product = null;
        if(type.equalsIgnoreCase("banana")){
            product = new Banana();
        }else if(type.equalsIgnoreCase("apple")){
            product = new Apple();
        }
        return product;
    }
}

/**客户端调用**/
class Client{
    /**
     *  在以下情况下可以考虑使用简单工厂模式：
     *     (1) 工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太 过复杂。
     *     (2) 客户端只知道传入工厂类的参数，对于如何创建对象并不关心。
     */
    public static void main(String[] args) {
        Product product;
        /**
         * type类型参数，可从配置文件获取，从而满足"开闭原则"
         */
        product = ProductFactory.getProduct("banana");
        product.display();

    }
}

