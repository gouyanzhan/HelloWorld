package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带奶泡的意大利咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 18:03:24
 */
class EspressoWithWhip extends Beverage {

    @Override
    public double cost() {
        return 8.0 + 3.5;
    }
}
