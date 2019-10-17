package com.siwuxie095.forme.designpattern.summary.pattern3rd.decorator.example1st;

/**
 * 豆浆（具体装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:49:20
 */
class Soy extends Condiment {

    Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 递归调用，获取最终结果
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.5 + getCostBySize();
    }
}
