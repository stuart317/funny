package com.zc.factory.factory;


interface Product {
    //抽象产品
    void say();
}

class Banana implements Product{
    @Override
    public void say() {
        System.out.println("海南香蕉4元一斤");
    }
}

class Apple implements Product{
    @Override
    public void say() {
        System.out.println("烟台红富士苹果6元一斤");
    }
}