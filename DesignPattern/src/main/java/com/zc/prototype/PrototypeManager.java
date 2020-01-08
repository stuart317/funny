package com.zc.prototype;

import java.util.Hashtable;

/**
 *  原型管理器(Prototype Manager)
 *
 *  是将多个原型对象存储在一个集合中供客户端使用，它是一个专门负责克隆对象的工厂，
 *  其中定义了一个集合用于存储原型对象，如果需要某个原型对象的一个克隆，可以通过复制集合中对应的原型对象来获得。
 *  在原型管理器中针对抽象原型类 进行编程，以便扩展。
 */

//抽象公文接口，也可定义为抽象类，提供clone()方法的实现，将业务方法声明为抽象方法
interface OfficialDocument extends Cloneable {
    OfficialDocument clone();
    void display();
}

//可行性分析报告(Feasibility Analysis Report)类
class FAR implements OfficialDocument {

    @Override
    public OfficialDocument clone() {

        OfficialDocument far = null;

        try {
            far = (OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
        }
        return far;
    }

    @Override
    public void display() {
        System.out.println("《可行性分析报告》");
    }
}

//软件需求规格说明书(Software Requirements Specification)类
class SRS implements OfficialDocument {

    @Override
    public OfficialDocument clone() {

        OfficialDocument srs = null;

        try {
            srs = (OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
        }
        return srs;
    }

    @Override
    public void display() {
        System.out.println("《软件需求规格说明书》");
    }
}

/***
 * 原型管理器（使用饿汉式单例实现）
 */
public class PrototypeManager {

    //定义一个 hashtable，用于存储原型对象
    private Hashtable ht = new Hashtable();
    private static PrototypeManager prototypeManager = new PrototypeManager();

    //为Hashtable增加公文对象
    private PrototypeManager(){
        ht.put("far",new FAR());
        ht.put("srs",new SRS());
    }

    //增加新的公文对象
    public void addOfficialDocument(String key,OfficialDocument doc) {
        ht.put(key,doc);
    }

    //通过浅克隆，获取新的公文对象
    public OfficialDocument getOfficialDocument(String key){
        OfficialDocument officialDocument = (OfficialDocument) ht.get(key);
        return officialDocument.clone();
    }

    public static PrototypeManager getInstance(){
        return prototypeManager;
    }
}

/**
 * 客户端
 */
class ClientGlq {
    public static void main(String[] args) {
        //获取原型管理器
        PrototypeManager prototypeManager = PrototypeManager.getInstance();

        OfficialDocument doc1,doc2,doc3,doc4;

        doc1 = prototypeManager.getOfficialDocument("far");
        doc1.display();
        doc2 = prototypeManager.getOfficialDocument("far");
        doc2.display();
        System.out.println(doc1 == doc2);

        doc3 = prototypeManager.getOfficialDocument("srs");
        doc3.display();
        doc4 = prototypeManager.getOfficialDocument("srs");
        doc4.display();
        System.out.println(doc3 == doc4);
    }
}