package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带奶泡的深焙咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 18:01:11
 */
class DarkRoastWithWhip extends Beverage {

    @Override
    public double cost() {
        return 6.0 + 3.5;
    }
}
