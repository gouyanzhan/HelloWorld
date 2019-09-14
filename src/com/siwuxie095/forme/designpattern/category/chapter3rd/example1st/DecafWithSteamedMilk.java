package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带蒸奶的脱咖啡因咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:40:55
 */
class DecafWithSteamedMilk extends Beverage {

    @Override
    public double cost() {
        return 7.0 + 0.5;
    }
}
