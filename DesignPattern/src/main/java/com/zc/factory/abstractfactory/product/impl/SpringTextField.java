package com.zc.factory.abstractfactory.product.impl;

import com.zc.factory.abstractfactory.product.TextField;

/**
 * Spring文本框类：具体产品
 */
public class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("我是spring文本框");
    }
}
