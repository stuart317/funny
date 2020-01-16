package com.zc.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 *  模拟借书  测试
 */
public class ClientStudent {

    //同学借了多少本书
    private static  List<Book> books = new ArrayList<>();
    private static Library library;

    public static void main(String[] args) {
        library = Library.getInstance();

        StudentBorrow("java编程思想");
        StudentBorrow("java核心卷一");
        StudentBorrow("headfirst设计模式");
        StudentBorrow("effective java第三版");

        System.out.println("后两本没有理解，又去借了一次");
        StudentBorrow("headfirst设计模式");
        StudentBorrow("effective java第三版");

        System.out.println("一共向图书馆借了多少本书："+books.size());
        System.out.println("图书馆书的数量："+library.getBookSize());
    }

    //借了的书，存起来
    private static void StudentBorrow(String name){
        books.add(library.libToBorrow(name));
    }

}
