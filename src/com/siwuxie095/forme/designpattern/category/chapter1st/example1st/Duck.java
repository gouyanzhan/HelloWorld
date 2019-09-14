package com.siwuxie095.forme.designpattern.category.chapter1st.example1st;

/**
 * 鸭子
 *
 * @author Jiajing Li
 * @date 2019-08-05 19:33:44
 */
abstract class Duck {

    /**
     * 呱呱叫
     *
     * 所有鸭子都会呱呱叫，可直接实现
     */
    void quack() {
        System.out.println("呱呱叫");
    }

    /**
     * 游泳
     *
     * 所有鸭子都会游泳，可直接实现
     */
    void swim() {
        System.out.println("游泳");
    }

    /**
     * 外观/外形
     *
     * 每一种鸭子的外观不同，所以是抽象方法，不能直接实现
     */
    abstract void display();

    /**
     * 飞行
     */
    void fly() {
        System.out.println("飞行");
    }

}
