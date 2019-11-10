package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * 计数的鸭子工厂
 *
 * 此工厂创建有装饰者的鸭子
 *
 * @author Jiajing Li
 * @date 2019-11-10 10:24:45
 */
class CountingDuckFactory extends AbstractDuckFactory {

    /*
     * 每个方法都先用叫声计数器装饰者将 Quackable 包装起来。模拟器
     * 并不知道有何不同，只知道它实现了 Quackable 接口。这时，就不
     * 用再担心鸭子的叫声没有被统计，因为现在所有的叫声都会被计算进
     * 去。
     */

    @Override
    Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    Quackable createGooseDuck() {
        return new QuackCounter(new GooseAdapter(new Goose()));
    }
}
