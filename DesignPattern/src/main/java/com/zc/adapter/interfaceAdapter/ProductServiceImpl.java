package com.zc.adapter.interfaceAdapter;

/**
 *  ● ConcreteServiceClass（具体业务类）：它是缺省适配器类的子类，在没有引入适配器之前，它需要实现
 *       适配者接口，因此需要实现在适配者接口中定义的所有方法，而对于一些无须使用的方法也不得不提供空实现。
 *       在有了缺省适配器之后，可以直接继承该适配器类，根据需要有选择性地覆盖在适配器类中定义的方法。
 *
 *
 *      本来应该实现 ProductService ，但是我们并不需要 那么多方法，
 *      所以利用 接口适配器，只需要继承 需要的方法即可
 */
public class ProductServiceImpl extends InterfaceAdapter {

    @Override
    public void find() {
        System.out.println("我是适配器find方法");
    }

    @Override
    public void run() {
        System.out.println("我是适配器run方法");
    }

    public void find2() {
        System.out.println("我是实现类自己的方法");
    }
}
