package com.zc.prototype;

/**
 * 浅克隆
 *
 * 在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；如果原型对象的 成员变量是引用类型，
 * 则将引用对象的地址复制一份给克隆对象，也就是说原型对象和克隆 对象的成员变量指向相同的内存地址。
 * 简单来说，在浅克隆中，当对象被复制时只复制它本 身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制
 */
public class ShallowClone {

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
 * 工作周报类
 */
class WeeklyLog implements Cloneable{
    /**
     * 能够实现克隆的Java类必须实现一个标识接口Cloneable，表示这个Java类支持被 复制。
     */
    //为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含
    private String date;
    private String content;
    private ShallowClone shallowClone;

    //使用clone()方法实现浅克隆
    public WeeklyLog clone(){
        try {
            Object obj = super.clone();
            return (WeeklyLog)obj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("不支持复制！");
            return null;
        }
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

    public ShallowClone getShallowClone() {
        return shallowClone;
    }

    public void setShallowClone(ShallowClone shallowClone) {
        this.shallowClone = shallowClone;
    }
}

/**
 * 客户端
 */
class Client{
    public static void main(String[] args) {

        /**
         * 结论:  浅克隆 不会克隆 引用类型的成员变量
         */

        WeeklyLog log_previous, log_new;
        log_previous = new WeeklyLog(); //创建原型对象

        ShallowClone shallowClone = new ShallowClone(); //创建附件对象
        log_previous.setShallowClone(shallowClone); //将附件添加到周报

        log_new = log_previous.clone(); //调用克隆方法创建克隆对象

        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getShallowClone() == log_new.getShallowClone()));
    }
}