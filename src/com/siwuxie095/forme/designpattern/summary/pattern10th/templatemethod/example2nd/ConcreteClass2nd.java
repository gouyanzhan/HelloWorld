package com.siwuxie095.forme.designpattern.summary.pattern10th.templatemethod.example2nd;

/**
 * 二号具体类
 *
 * @author Jiajing Li
 * @date 2019-11-05 15:30:47
 */
class ConcreteClass2nd extends AbstractClass {

    /*
     * 可以有许多个具体类，每一个都实现了模板方法所需的全部操作。
     *
     * 这个具体类实现抽象的操作，当模板方法需要这两个抽象方法时，
     * 会调用它们。
     */

    @Override
    void primitiveOperation1() {

    }

    @Override
    void primitiveOperation2() {

    }
}
