package com.siwuxie095.forme.designpattern.category.chapter3rd.example2nd;

/**
 * 黑咖啡
 *
 * @author Jiajing Li
 * @date 2019-10-09 20:42:15
 */
class HouseBlend extends Beverage {

    @Override
    public double cost() {
        return 5.0 + super.cost();
    }
}
