package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 橡皮鸭
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:13:07
 */
class RubberDuck extends Duck {

    RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    @Override
    void display() {
        System.out.println("外观是橡皮");
    }
}
