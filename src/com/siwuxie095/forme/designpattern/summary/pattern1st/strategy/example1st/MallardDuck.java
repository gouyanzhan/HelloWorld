package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 绿头鸭
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:06:52
 */
class MallardDuck extends Duck {

    MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("外观是绿头");
    }
}
