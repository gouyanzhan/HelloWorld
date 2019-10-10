package com.siwuxie095.forme.designpattern.category.chapter3rd.example2nd;

/**
 * 深焙咖啡
 *
 * @author Jiajing Li
 * @date 2019-10-09 20:42:31
 */
class DarkRoast extends Beverage {

    @Override
    public double cost() {
        return 6.0 + super.cost();
    }
}
