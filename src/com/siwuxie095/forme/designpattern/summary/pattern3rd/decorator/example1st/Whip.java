package com.siwuxie095.forme.designpattern.summary.pattern3rd.decorator.example1st;

/**
 * 奶泡（具体装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 13:43:24
 */
class Whip extends Condiment {

    /**
     * 递归调用，获取最终结果
     */
    Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3.5 + getCostBySize();
    }
}
