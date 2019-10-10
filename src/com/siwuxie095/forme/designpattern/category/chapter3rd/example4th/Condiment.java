package com.siwuxie095.forme.designpattern.category.chapter3rd.example4th;

/**
 * 调料（装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:32:00
 */
abstract class Condiment extends Beverage {

    /*
     * 因为必须让 Condiment 能够取代 Beverage，所以将
     * Condiment 扩展自 Beverage。
     */

    /**
     * 因为装饰者要包装组件，所以装饰者中要有一个对组件的引用。
     *
     * 它可以定义在装饰者的超类中，也可以定义在子类中。这里是
     * 前者。
     */
    Beverage beverage;

    /**
     * 所有的调料装饰者必须重新实现 getDescription() 方法。
     */
    @Override
    public abstract String getDescription();

}
