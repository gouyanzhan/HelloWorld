package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带蒸奶的深焙咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:32:19
 */
class DarkRoastWithSteamedMilk extends Beverage {

    @Override
    public double cost() {
        return 6.0 + 0.5;
    }
}
