package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 诱饵鸭
 *
 * @author Jiajing Li
 * @date 2019-08-06 22:15:36
 */
class DecoyDuck extends Duck {

    DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("外观是木头");
    }
}
