package com.zc.adapter.interfaceAdapter;

/**
 *  接口适配器 ，客户端调用
 */
public class Client {
    public static void main(String[] args) {

        ProductService productService = new ProductServiceImpl();
        productService.find();
        productService.run();
        productService.display(); //实现类 没有实现该方法
    }
}
