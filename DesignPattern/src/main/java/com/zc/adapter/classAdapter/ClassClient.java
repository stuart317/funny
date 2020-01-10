package com.zc.adapter.classAdapter;

/**
 * 类适配器 客户端
 *
 * 不兼容结构的协调——适配器模式
 */
class ClassClient {
    public static void main(String[] args) {

        // 需求 想用老式 MicroUSB 去充电 TypeC插口
        MicroUSB microUSB = new ClassAdapter();
        microUSB.isMicroUSB(); //这里使用的 MicroUSB老式方法，实际调用的是 TypeC方法
    }
}
