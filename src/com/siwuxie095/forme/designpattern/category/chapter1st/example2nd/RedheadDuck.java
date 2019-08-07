package com.siwuxie095.forme.designpattern.category.chapter1st.example2nd;

/**
 * 红头鸭
 *
 * @author Jiajing Li
 * @date 2019-08-05 20:46:44
 */
class RedheadDuck extends Duck implements Flyable, Quackable {

    @Override
    void display() {
        System.out.println("外观是红头");
    }

    @Override
    public void fly() {
        System.out.println("飞行");
    }

    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
