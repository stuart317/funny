package com.zc.factory.abstractfactory.product.impl;

import com.zc.factory.abstractfactory.product.Button;

/**
 * Spring按钮类：具体产品
 */
public class SpingButton implements Button {
    @Override
    public void display() {
        System.out.println("我是spring按钮【浅绿色】");
    }
}
