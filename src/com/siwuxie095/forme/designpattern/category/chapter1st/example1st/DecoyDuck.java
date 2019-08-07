package com.siwuxie095.forme.designpattern.category.chapter1st.example1st;

/**
 * 诱饵鸭
 *
 * @author Jiajing Li
 * @date 2019-08-05 20:22:58
 */
class DecoyDuck extends Duck {

    /**
     * 诱饵鸭不会叫
     */
    @Override
    void quack() {
        // 覆盖，变成什么事都不做
    }

    @Override
    void display() {
        // 外观是木头
        System.out.println("外观是木头");
    }

    /**
     * 诱饵鸭不会飞
     */
    @Override
    void fly() {
        // 覆盖，变成什么事都不做
    }
}
