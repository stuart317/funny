package com.zc.adapter.ObjectAdapter;

import com.zc.adapter.classAdapter.MicroUSB;
import com.zc.adapter.classAdapter.TypeC;


/**
 * 对象适配器
 *
 *
 * 适配器模式(Adapter Pattern)：
 *      将一个接口转换成客户希望的另一个接口，使接口不兼容的那 些类可以一起工作，其别名为包装器(Wrapper)。
 *      适配器模式既可以作为类结构型模式，也可 以作为对象结构型模式。
 *
 *
 *  ● Target（目标抽象类）：目标抽象类定义客户所需接口，可以是一个抽象类或接口，也可以是具体类。
 *
 *  ● Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进
 *            行适配，适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个
 *            Adaptee对象使二者产生联系。
 *
 *  ● Adaptee（适配者类）：适配者即被适配的角色，它定义了一个已经存在的接口，这个接口 需要适配，
 *            适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可能没有适配者类的源代码。
 */

/**
 *  对象适配器：代理实现，动态组合模式
 *
 *      对象适配器使用的是组合的方式，·所以Adaptee及其子孙类都可以被适配。另外，对象适配器对于增加一些新行为
 *      非常方便，而且新增加的行为同时适用于所有的源。
 *
 */
public class ObjectAdapter implements MicroUSB {

    private TypeC typeC;

    public ObjectAdapter(TypeC typeC){
        this.typeC = typeC;
    }

    @Override
    public void isMicroUSB() {
        typeC.isTypeC();
    }
}
