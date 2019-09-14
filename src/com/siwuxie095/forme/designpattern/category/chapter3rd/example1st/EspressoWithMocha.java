package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带摩卡的意大利咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:45:27
 */
class EspressoWithMocha extends Beverage {

    @Override
    public double cost() {
        return 8.0 + 2.5;
    }
}
