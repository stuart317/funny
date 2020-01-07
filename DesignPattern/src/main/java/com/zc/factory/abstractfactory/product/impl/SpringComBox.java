package com.zc.factory.abstractfactory.product.impl;

import com.zc.factory.abstractfactory.product.ComBox;

/**
 * spring复选框类：具体产品
 */
public class SpringComBox implements ComBox {
    @Override
    public void display() {
        System.out.println("我是spring复选框");
    }
}
