package com.zc.prototype;

import java.io.*;

/**
 * 深克隆
 *
 *  在深克隆中，无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，
 *  深克隆将原型对象的所有引用对象也复制一份给克隆对象。简单来说，在深克隆中，除了对 象本身被复制外，
 *  对象所包含的所有成员变量也将复制
 *
 *  实现深克隆，可以通过序列化(Serialization)等方式来实现。序列化就 是将对象写到流的过程，
 *  写到流中的对象是原有对象的一个拷贝，而原对象仍然存在于内存 中。通过序列化实现的拷贝不仅可以复制对象本身，
 *  而且可以复制其引用的成员对象，因此 通过序列化将对象写到一个流中，再从流里将其读出来，可以实现深克隆。
 *  需要注意的是能 够实现序列化的对象其类必须实现 Serializable 接口，否则无法实现序列化操作。
 */
public class DeepClone implements Serializable {

    /**
     * 附件类
     */
    private String name; //附件名

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 工作周报类WeeklyLog不再使用Java自带的克隆机制，而是通过序列化来从头实现对象的深克隆，
 * 我们需要重新编写clone()方法
 */
class WeeklyLog2 implements Serializable{

    //为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含
    private String date;
    private String content;
    private DeepClone deepClone;

    //使用序列化技术实现深克隆
    public WeeklyLog2 deepClone() throws Exception{

        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(bao);
        outputStream.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        return (WeeklyLog2) objectInputStream.readObject();
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DeepClone getDeepClone() {
        return deepClone;
    }

    public void setDeepClone(DeepClone deepClone) {
        this.deepClone = deepClone;
    }
}

/**
 * 客户端
 *
 * 对象的克隆——原型模式
 */
class Client2{
    public static void main(String[] args) throws Exception {

        /**
         * 结论:
         *
         *  由于使用了深克隆技术，附件对象也得以复制，因此用“==”比较原型 对象的附件和克隆对象的附件时
         *  输出结果均为false。深克隆技术实现了原型对象和克隆对象的 完全独立，对任意克隆对象的修改都
         *  不会给其他对象产生影响，是一种更为理想的克隆实现 方式。
         */

        WeeklyLog2 log_previous, log_new;
        log_previous = new WeeklyLog2(); //创建原型对象

        DeepClone deepClone = new DeepClone(); //创建附件对象
        log_previous.setDeepClone(deepClone); //将附件添加到周报

        log_new = log_previous.deepClone(); //调用  深克隆方法创建克隆对象
        System.out.println("=====:"+log_new.getDeepClone().getName());

        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getDeepClone() == log_new.getDeepClone()));
    }
}