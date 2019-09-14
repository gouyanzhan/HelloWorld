package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带蒸奶的黑咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:28:30
 */
class HouseBlendWithSteamedMilk extends Beverage {

    @Override
    public double cost() {
        return 5.0 + 0.5;
    }
}
