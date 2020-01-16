package com.zc.strategy;

/**
 * 环境类实现
 */
public class TravelerContext {

    //出行策略接口
    IStrategy iStrategy;

    //设置出行策略
    public void setIStrategy(IStrategy iStrategy){
        this.iStrategy = iStrategy;
    }

    //当前用户出行方式
    public void travelStyle() {
        iStrategy.travelStyle();
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        TravelerContext travelerContext = new TravelerContext();

        //travelerContext.setIStrategy(new TrainStrategy()); //选择具体出行方式
        travelerContext.setIStrategy(new AirStrategy());

        travelerContext.travelStyle();

    }
}
