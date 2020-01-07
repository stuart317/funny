package com.zc.factory.abstractfactory.factory;

import com.zc.factory.abstractfactory.product.Button;
import com.zc.factory.abstractfactory.product.ComBox;
import com.zc.factory.abstractfactory.product.TextField;
import com.zc.factory.abstractfactory.product.impl.SpingButton;
import com.zc.factory.abstractfactory.product.impl.SpringComBox;
import com.zc.factory.abstractfactory.product.impl.SpringTextField;

/**
 * spring皮肤工厂 : 具体工厂
 */
public class SpringSkinFactory implements SkinFactory {

    @Override
    public Button createButton() {
        return new SpingButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComBox createComBox() {
        return new SpringComBox();
    }
}
