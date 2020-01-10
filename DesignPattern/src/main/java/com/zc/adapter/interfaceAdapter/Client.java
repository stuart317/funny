package com.zc.adapter.interfaceAdapter;

/**
 *  接口适配器 ，客户端调用
 *
 *  不兼容结构的协调——适配器模式
 */
public class Client {
    public static void main(String[] args) {

        ProductService productService = new ProductServiceImpl();
        productService.find();
        productService.run();
        productService.display(); //实现类 没有实现该方法
    }
}
