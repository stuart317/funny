package com.zc.factory.abstractfactory.factory;

import com.zc.factory.abstractfactory.product.Button;
import com.zc.factory.abstractfactory.product.ComBox;
import com.zc.factory.abstractfactory.product.TextField;
import com.zc.factory.abstractfactory.product.impl.SummerButton;
import com.zc.factory.abstractfactory.product.impl.SummerComBox;
import com.zc.factory.abstractfactory.product.impl.SummerTextField;

/**
 * summer皮肤工厂 ：具体工厂
 */
public class SummerSkinFactory implements SkinFactory{

    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComBox createComBox() {
        return new SummerComBox();
    }
}
