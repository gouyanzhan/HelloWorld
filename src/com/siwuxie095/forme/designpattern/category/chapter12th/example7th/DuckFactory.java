package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * 鸭子工厂
 *
 * 此工厂创建没有装饰者的鸭子
 *
 * @author Jiajing Li
 * @date 2019-11-10 10:21:57
 */
class DuckFactory extends AbstractDuckFactory {

    /*
     * 每个方法创建一个产品：一种特定种类的 Quackable。
     * 模拟器并不知道实际的产品是什么，只知道它实现了
     * Quackable 接口。
     */

    @Override
    Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    Quackable createGooseDuck() {
        return new GooseAdapter(new Goose());
    }
}
