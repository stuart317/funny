package com.zc.builder;

import lombok.Data;

/**
 *  建造者模式 【链式写法(非常推荐)】
 */
@Data
public class ChainProduct {

    //① 产品角色
    private String name;
    private String password;
    private String phone;

    private ChainProduct(Builder builder){
        name = builder.name;
        password = builder.password;
        phone = builder.phone;
    }


    //静态建造器Builder(静态内部类)
    //② 具体建造者
    public static final class Builder {
        private String name;
        private String password;
        private String phone;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        // 通过build实例化实体类
        public ChainProduct build(){
            return new ChainProduct(this);
        }
    }
}

/**
 * 客户端
 */
class ClientChain{
    public static void main(String[] args) {

        ChainProduct product = new ChainProduct.Builder()
                .setName("张飞")
                .setPassword("qwe1233333")
                .setPhone("13200000000")
                .build();

        System.out.println(product.toString());
    }
}
