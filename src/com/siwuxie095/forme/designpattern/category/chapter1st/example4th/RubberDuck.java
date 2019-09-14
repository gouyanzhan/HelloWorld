package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 橡皮鸭
 *
 * @author Jiajing Li
 * @date 2019-08-06 22:12:59
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
