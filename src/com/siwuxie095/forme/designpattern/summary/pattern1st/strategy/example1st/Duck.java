package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 鸭子
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:04:43
 */
abstract class Duck {

    /**
     * 每只鸭子都会引用实现 FlyBehavior 接口的对象
     */
    FlyBehavior flyBehavior;
    /**
     * 每只鸭子都会引用实现 QuackBehavior 接口的对象
     */
    QuackBehavior quackBehavior;

    Duck() {}

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
     * 将飞行的动作委托给行为类处理
     */
    void performFly() {
        flyBehavior.fly();
    }

    /**
     * 将叫的动作委托给行为类处理
     */
    void performQuack() {
        quackBehavior.quack();
    }

    /**
     * 设定飞行行为
     */
    void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    /**
     * 设定呱呱叫行为
     */
    void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}

