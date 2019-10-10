package com.siwuxie095.forme.designpattern.category.chapter3rd.example4th;

/**
 * 奶泡（具体装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 13:43:24
 */
class Whip extends Condiment {

    Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3.5;
    }
}
