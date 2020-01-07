package com.zc.factory.abstractfactory.product.impl;

import com.zc.factory.abstractfactory.product.Button;

/**
 * summer按钮类：具体产品
 */
public class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("我是summer按钮【蓝色】");
    }
}
