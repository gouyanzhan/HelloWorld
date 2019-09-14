package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 火箭动力的飞行
 *
 * @author Jiajing Li
 * @date 2019-08-06 22:21:15
 */
class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("火箭动力的飞行");
    }
}
