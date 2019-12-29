package com.siwuxie095.forme.designpattern.category.chapter8th.example4th;

/**
 * 抽象类
 *
 * @author Jiajing Li
 * @date 2019-11-05 15:25:06
 */
abstract class AbstractClass {

    /*
     * 这个抽象类中包含了模板方法。
     *
     * 模板方法在实现算法的过程中，用到了本类中的这两个原语操作。
     * 模板方法本身和这两个操作的具体实现之间被解耦了。
     *
     * 这里的原语操作是指：模板方法所用到的操作的抽象版本。
     */

    /**
     * 模板方法
     *
     * （1）被声明为 final，以免子类改变这个算法的顺序。
     * （2）模板方法定义了一连串的步骤，每个步骤由一个方法代表。
     */
    final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    /**
     * 原语操作 1
     *
     * 子类必须实现它。
     */
    abstract void primitiveOperation1();

    /**
     * 原语操作 2
     *
     * 子类必须实现它。
     */
    abstract void primitiveOperation2();

    /**
     * 具体操作
     *
     * （1）被声明为 final，这样一来，子类就无法覆盖它。
     * （2）它可以被模板方法直接使用，或者被子类使用。
     */
    final void concreteOperation() {
        // 这里是实现
    }

    /**
     * 钩子
     *
     * 默认不做事的方法，称这种方法为钩子（hook）。子类
     * 可以视情况决定要不要覆盖它。
     *
     * 注：钩子方法中可以是空实现，也可以是默认实现。
     */
    void hook() {}

}
