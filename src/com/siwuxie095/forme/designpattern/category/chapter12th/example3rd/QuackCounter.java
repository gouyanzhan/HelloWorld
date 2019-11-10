package com.siwuxie095.forme.designpattern.category.chapter12th.example3rd;

/**
 * 呱呱叫计数器（鸭叫计数器）
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:56:45
 */
class QuackCounter implements Quackable {

    /*
     * QuackCounter 是一个装饰者，需要实现目标接口 Quackable。
     */

    /**
     * 用一个实例变量来记录被装饰的呱呱叫者。
     */
    private Quackable duck;

    /**
     * 用静态变量跟踪所有呱呱叫次数。
     */
    private static int numberOfQuacks;

    QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    /**
     * 当 quack() 被调用时，就把调用委托给正在装饰
     * 的 Quackable 对象。然后把叫声的次数加一。
     */
    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    /**
     * 给装饰者加一个静态方法，以便返回在所有 Quackable 中
     * 发生的叫声次数。
     */
    static int getQuacks() {
        return numberOfQuacks;
    }
}
