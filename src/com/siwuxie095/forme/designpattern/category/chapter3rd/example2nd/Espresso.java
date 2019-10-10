package com.siwuxie095.forme.designpattern.category.chapter3rd.example2nd;

/**
 * 意大利咖啡
 *
 * @author Jiajing Li
 * @date 2019-10-09 20:43:19
 */
class Espresso extends Beverage {

    @Override
    public double cost() {
        return 8.0 + super.cost();
    }
}
