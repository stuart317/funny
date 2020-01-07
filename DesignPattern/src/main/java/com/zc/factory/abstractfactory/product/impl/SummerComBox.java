package com.zc.factory.abstractfactory.product.impl;

import com.zc.factory.abstractfactory.product.ComBox;

/**
 * summer复选框类：具体产品
 */
public class SummerComBox implements ComBox {
    @Override
    public void display() {
        System.out.println("我是summer复选框");
    }
}
