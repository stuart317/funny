package com.zc.strategy;

/**
 * 具体策略类： 火车出行
 */
public class TrainStrategy implements IStrategy {
    @Override
    public void travelStyle() {
        System.out.println("乘坐火车....");
    }
}
