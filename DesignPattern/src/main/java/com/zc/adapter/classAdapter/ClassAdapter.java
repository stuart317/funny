package com.zc.adapter.classAdapter;

/**
 *  类适配器：继承实现，静态定义
 *
 *
 *  类适配器与对象适配器的区别:
 *
 *      1、类适配器使用的是继承的方式，直接继承了Adaptee，所以无法对Adaptee的子类进行适配。
 *
 *      2、对象适配器使用的是组合的方式，·所以Adaptee及其子孙类都可以被适配。另外，对象适配器对于增加一些新行为
 *      非常方便，而且新增加的行为同时适用于所有的源。
 *
 *      基于组合/聚合优于继承的原则，使用对象适配器是更好的选择。
 *
 *     【最大的区别在于适配器和适配者之间的关系不同，对象适配器模式中适配
 *       器和适配者之间是关联关系，而类适配器模式中适配器和适配者是继承关系】

 */
public class ClassAdapter extends TypeCImpl implements MicroUSB  {

    @Override
    public void isMicroUSB() {
        isTypeC();
    }
}



