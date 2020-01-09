package com.zc.adapter.interfaceAdapter;

/**
 * 缺省适配器模式 ，又称【单接口适配器】
 *
 *          当不需要实现一个接口所提供的所有方法时，可先 设计一个抽象类实现该接口，并为接口中每个方法提供一个
 *      默认实现（空方法），那么该抽 象类的子类可以选择性地覆盖父类的某些方法来实现需求，它适用于不想使用
 *      一个接口中的 所有方法的情况，又称为单接口适配器模式。
 *
 *
 *    ● ServiceInterface（适配者接口）：它是一个接口，通常在该接口中声明了大量的方法。
 *
 *    ● AbstractServiceClass（缺省适配器类）：它是缺省适配器模式的核心类，使用空方法的形式实现了在
 *      ServiceInterface接口中声明的方法。通常将它定义为抽象类，因为对它进行实例化没 有任何意义。
 *
 *    ● ConcreteServiceClass（具体业务类）：它是缺省适配器类的子类，在没有引入适配器之前，它需要实现
 *      适配者接口，因此需要实现在适配者接口中定义的所有方法，而对于一些无须使 用的方法也不得不提供空实现。
 *      在有了缺省适配器之后，可以直接继承该适配器类，根据需 要有选择性地覆盖在适配器类中定义的方法。
 */

/**
 * AbstractServiceClass（接口适配器【缺省适配器】）
 */
public abstract class InterfaceAdapter implements ProductService{

    /**
     * 方法实现都是空
     */
    public void find() { }

    public void run() { }

    public void display() { }

    public void delete() { }
}
