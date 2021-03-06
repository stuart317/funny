package com.zc.strategy;

/**
 * 算法的封装与切换——策略模式
 *
 *     策略模式用于算法的自由切换和扩展，它是应用较为广泛的设计模式之一。策略模式对应于解决某一问题的一个算法族，
 * 允许用户从该算法族中任选一个算法来解决某一问题，同时可 以方便地更换算法或者增加新的算法。只要涉及到算法
 * 的封装、复用和切换都可以考虑使用 策略模式。
 *
 * 环境类(Context):用来操作策略的上下文环境，也就是我们游客。
 * 抽象策略类(Strategy):策略的抽象，出行方式的抽象
 * 具体策略类(ConcreteStrategy):具体的策略实现，每一种出行方式的具体实现。
 *
 *
 * 策略模式，就是一个问题有好几种解法，我们选择其中一种就可以了。
 */

/**
 * 抽象策略类： 出行方式接口
 */
public interface IStrategy {
    public void travelStyle();
}
