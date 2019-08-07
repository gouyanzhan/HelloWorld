package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * @author Jiajing Li
 * @date 2019-08-06 22:23:42
 */
class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("外观是模型");
    }
}
