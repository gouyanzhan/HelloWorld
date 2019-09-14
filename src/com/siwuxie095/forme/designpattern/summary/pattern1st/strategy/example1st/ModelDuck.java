package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 模型鸭
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:13:41
 */
class ModelDuck extends Duck {

    ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("外观是模型");
    }
}
