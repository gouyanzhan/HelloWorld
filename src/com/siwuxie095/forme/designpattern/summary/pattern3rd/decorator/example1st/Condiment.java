package com.siwuxie095.forme.designpattern.summary.pattern3rd.decorator.example1st;

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

    /**
     * 递归调用，获取最终结果
     */
    @Override
    public int getSize() {
        return beverage.getSize();
    }

    /**
     * 调料会根据饮料容量大小，分别加收一定的费用。
     */
    public double getCostBySize() {
        double cost = .0;
        if (getSize() == Beverage.TALL) {
            cost += .1;
        } else if (getSize() == Beverage.GRANDE) {
            cost += .2;
        } else if (getSize() == Beverage.VENTI) {
            cost += .3;
        }
        return cost;
    }

}
