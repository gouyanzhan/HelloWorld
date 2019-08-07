package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 红头鸭
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:07:38
 */
class RedheadDuck extends Duck {

    RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("外观是红头");
    }
}
