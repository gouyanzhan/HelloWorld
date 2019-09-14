package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 火箭动力的飞行
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:08:28
 */
class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("火箭动力的飞行");
    }
}
