package com.zc.builder;

import lombok.Data;
/**
 * ● Builder（抽象建造者）：它为创建一个产品Product对象的各个部件指定抽象接口，在该接 口中一般声明两类方法，一类方法是
 *         buildPartX()，它们用于创建复杂对象的各个部件；另一 类方法是getResult()，它们用于返回复杂对象。
 *         Builder既可以是抽象类，也可以是接口。
 *
 * ● ConcreteBuilder（具体建造者）：它实现了Builder接口，实现各个部件的具体构造和装配方 法，定义并明确它
 *          所创建的复杂对象，也可以提供一个方法返回创建好的复杂产品对象。
 *
 * ● Product（产品角色）：它是被构建的复杂对象，包含多个组成部件，具体建造者创建该产品 的内部表示并定义
 *          它的装配过程。
 *
 * ● Director（指挥者）：指挥者又称为导演类，它负责安排复杂对象的建造次序，指挥者与抽 象建造者之间存在
 *          关联关系，可以在其construct()建造方法中调用建造者对象的部件构造与装 配方法，完成复杂对象的建造。
 *          客户端一般只需要与指挥者进行交互，在客户端确定具体建 造者的类型，并实例化具体建造者对象（也可以
 *          通过配置文件和反射机制），然后通过指挥 者类的构造函数或者Setter方法将该对象传入指挥者类中。
 *
 */

/**
 *
 * 建造者模式  【原型写法】
 *
 */
abstract class PrototypeBuilder {
    //创建产品对象
    Product product = new Product();

    /**
     *  在抽象类Builder中声明了一系列抽象的buildPartX()方法用于创建复杂产品的各个部件，
     *  具体 建造过程在ConcreteBuilder中实现
     */
    public abstract void buildName();
    public abstract void buildColor();

    //提供了工厂方法 createProduct()，用于返回一个建造好 的完整产品。
    public Product createProduct(){
        return product;
    }
}

/**
 * 产品
 */
@Data
class Product{
    private String name;
    private String color;
}

/**
 *  苹果建造器：具体建造者
 */
class AppleBuilder extends PrototypeBuilder{
    @Override
    public void buildName() {
        product.setName("苹果");
    }
    @Override
    public void buildColor() {
        product.setColor("红色");
    }
}

/**
 *  香蕉建造器：具体建造者
 */
class BananaBuilder extends PrototypeBuilder{
    @Override
    public void buildName() {
        product.setName("香蕉");
    }
    @Override
    public void buildColor() {
        product.setColor("黄色");
    }
}

/**
 * 指挥者 【Director】
 */
class ProcuctController{

    //逐步构建复杂产品对象
    public Product construct(PrototypeBuilder pb){
        Product product;
        pb.buildColor();
        pb.buildName();
        product = pb.createProduct();
        return product;
    }
}

/**
 * 客户端
 */
class Client4{
    public static void main(String[] args) {

        //针对抽象建造者编程    生成具体建造者
        //PrototypeBuilder pb = new AppleBuilder();
        PrototypeBuilder pb = new BananaBuilder();

        ProcuctController procuctController = new ProcuctController();
        //通过指挥者创建完整的建造者对象
        Product product = procuctController.construct(pb);

        System.out.println("========"+product.getName());
        System.out.println("========"+product.getColor());
    }
}