package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带蒸奶的意大利咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:44:21
 */
class EspressoWithSteamedMilk extends Beverage {

    @Override
    public double cost() {
        return 8.0 + 0.5;
    }
}
