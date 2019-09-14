package com.siwuxie095.forme.designpattern.category.chapter1st.example2nd;

/**
 * 橡皮鸭
 *
 * @author Jiajing Li
 * @date 2019-08-05 20:48:14
 */
class RubberDuck extends Duck implements Quackable {

    @Override
    void display() {
        System.out.println("外观是橡皮");
    }

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
