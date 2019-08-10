package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 绿头鸭
 *
 * @author Jiajing Li
 * @date 2019-08-06 22:06:56
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
