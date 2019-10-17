package com.siwuxie095.forme.designpattern.category.chapter3rd.example5th;

/**
 * 蒸奶（具体装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:43:56
 */
class SteamedMilk extends Condiment {

    SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 递归调用，获取最终结果
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5 + getCostBySize();
    }
}
