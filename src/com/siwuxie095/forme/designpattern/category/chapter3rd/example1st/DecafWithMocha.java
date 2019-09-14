package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带摩卡的脱咖啡因咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:42:42
 */
class DecafWithMocha extends Beverage {

    @Override
    public double cost() {
        return 7.0 + 2.5;
    }
}
