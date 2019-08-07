package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 诱饵鸭
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:13:20
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
