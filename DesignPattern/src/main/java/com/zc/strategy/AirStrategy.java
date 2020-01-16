package com.zc.strategy;

/**
 * 具体策略类： 飞机出行
 */
public class AirStrategy implements IStrategy {
    @Override
    public void travelStyle() {
        System.out.println("乘坐飞机....");
    }
}
