package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带摩卡带的深焙咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:33:26
 */
class DarkRoastWithMocha extends Beverage {

    @Override
    public double cost() {
        return 6.0 + 2.5;
    }
}
