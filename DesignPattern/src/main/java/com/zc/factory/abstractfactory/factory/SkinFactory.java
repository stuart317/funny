package com.zc.factory.abstractfactory.factory;

import com.zc.factory.abstractfactory.product.Button;
import com.zc.factory.abstractfactory.product.ComBox;
import com.zc.factory.abstractfactory.product.TextField;

/**
 * 皮肤抽象工厂
 */
public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComBox createComBox();
}
