package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带豆浆的黑咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:30:09
 */
class HouseBlendWithSoy extends Beverage {

    @Override
    public double cost() {
        return 5.0 + 1.5;
    }
}
