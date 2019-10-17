package com.siwuxie095.forme.designpattern.category.chapter3rd.example4th;

/**
 * 摩卡（具体装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:51:17
 */
class Mocha extends Condiment {

    Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3.5;
    }
}
