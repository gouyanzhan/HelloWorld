package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 *
 * 带奶泡的黑咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 18:00:21
 */
class HouseBlendWithWhip extends Beverage {

    @Override
    public double cost() {
        return 5.0 + 3.5;
    }
}
