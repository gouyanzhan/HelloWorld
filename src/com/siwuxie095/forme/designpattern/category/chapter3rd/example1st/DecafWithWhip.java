package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带奶泡的脱咖啡因咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 18:02:18
 */
class DecafWithWhip extends Beverage {

    @Override
    public double cost() {
        return 7.0 + 3.5;
    }
}
