package com.zc.factory.abstractfactory.product.impl;

import com.zc.factory.abstractfactory.product.TextField;

/**
 * Summer文本框类：具体产品
 */
public class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("我是summer文本框");
    }
}
