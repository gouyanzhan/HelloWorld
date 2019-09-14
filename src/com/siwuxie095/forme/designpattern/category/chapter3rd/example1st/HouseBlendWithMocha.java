package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带摩卡的黑咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:31:03
 */
class HouseBlendWithMocha extends Beverage {

    @Override
    public double cost() {
        return 5.0 + 2.5;
    }
}
