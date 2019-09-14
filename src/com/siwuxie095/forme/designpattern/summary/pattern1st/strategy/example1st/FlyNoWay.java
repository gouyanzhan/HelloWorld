package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 不会飞
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:08:11
 */
class FlyNoWay implements FlyBehavior {

    /**
     * 这里实现了所有不会飞的鸭子的动作
     */
    @Override
    public void fly() {
        // 什么都不做，不会飞
        System.out.println("不会飞");
    }
}
