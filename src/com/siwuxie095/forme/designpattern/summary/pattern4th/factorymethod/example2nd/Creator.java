package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example2nd;

/**
 * 抽象创建者
 *
 * @author Jiajing Li
 * @date 2019-10-12 17:29:41
 */
abstract class Creator {

    /*
     * 抽象创建者中实现了所有操纵产品的方法，但不实现工厂方法。
     */

    /**
     * 操作产品的方法
     */
    void anOperation(String type) {
        Product product = factoryMethod("undefined");
        // do something ...
    }

    /**
     * 工厂方法：
     *
     * 它用来处理对象的创建，并将这样的行为封装在子类中。
     *
     * 这样，客户程序中关于超类的代码就和子类对象创建代
     * 码解耦了。
     * 释义：
     * （1）客户程序 即 anOperation()。
     * （2）关于超类的代码 即 Product product。
     * （3）子类对象创建代码 即 具体创建者中的 factoryMethod()。
     *
     * 注意：
     * （1）工厂方法是抽象的，所以依赖子类来处理对象的创建。
     * （2）工厂方法必须返回一个产品。超类中定义的方法，通
     * 常会使用到工厂方法的返回值。
     * （3）工厂方法将客户和实际创建具体产品的代码分隔开来。
     * （4）工厂方法可能需要参数（也可能不需要）来指定所要
     * 的产品。
     */
    abstract Product factoryMethod(String type);

}
