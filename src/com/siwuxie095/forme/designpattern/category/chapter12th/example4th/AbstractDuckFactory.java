package com.siwuxie095.forme.designpattern.category.chapter12th.example4th;

/**
 * 抽象鸭子工厂
 *
 * @author Jiajing Li
 * @date 2019-11-10 10:17:09
 */
abstract class AbstractDuckFactory {

    /*
     * 定义一个抽象工厂，它的子类会创建不同的家族。
     */

    /**
     * 创建绿头鸭
     */
    abstract Quackable createMallardDuck();

    /**
     * 创建红头鸭
     */
    abstract Quackable createRedheadDuck();

    /**
     * 创建鸭鸣器
     */
    abstract Quackable createDuckCall();

    /**
     * 创建橡皮鸭
     */
    abstract Quackable createRubberDuck();

}
