package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 红头鸭
 *
 * @author Jiajing Li
 * @date 2019-08-06 22:11:42
 */
class RedheadDuck extends Duck {

    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("外观是红头");
    }
}
