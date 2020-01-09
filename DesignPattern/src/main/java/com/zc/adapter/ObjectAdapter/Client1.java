package com.zc.adapter.ObjectAdapter;

import com.zc.adapter.classAdapter.MicroUSB;
import com.zc.adapter.classAdapter.TypeC;
import com.zc.adapter.classAdapter.TypeCImpl;

/**
 * 客户端  对象适配器
 */
public class Client1 {

    public static void main(String[] args) {
        TypeC typeC = new TypeCImpl();
        MicroUSB microUSB = new ObjectAdapter(typeC);
        microUSB.isMicroUSB(); //对象适配器 ，组合模式
    }
}
