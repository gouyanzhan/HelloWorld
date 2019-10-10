package com.siwuxie095.forme.designpattern.category.chapter3rd.example3rd;

/**
 * 装饰者
 *
 * @author Jiajing Li
 * @date 2019-10-10 10:27:04
 */
abstract class Decorator extends Component {

    /**
     * 每个装饰者都 "有一个" 组件（包装一个组件），也就是说，装饰者有一个实例变量
     * 以保存某个 Component 的引用。
     *
     * 它可以定义在装饰者的超类中，也可以定义在子类中。
     */
    Component wrappedComponent;

    @Override
    public abstract void methodA();

    @Override
    public abstract void methodB();

}
