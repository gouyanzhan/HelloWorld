package com.siwuxie095.forme.designpattern.category.chapter1st.example1st;

/**
 * 橡皮鸭
 *
 * @author Jiajing Li
 * @date 2019-08-05 20:17:05
 */
class RubberDuck extends Duck {

    @Override
    void quack() {
        // 覆盖成吱吱叫
        System.out.println("吱吱叫");
    }

    @Override
    void display() {
        // 外观是橡皮
        System.out.println("外观是橡皮");
    }

    /**
     * 橡皮鸭不会飞
     */
    @Override
    void fly() {
        // 覆盖，变成什么事都不做
    }
}
