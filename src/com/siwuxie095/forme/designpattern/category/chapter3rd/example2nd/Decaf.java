package com.siwuxie095.forme.designpattern.category.chapter3rd.example2nd;

/**
 * 脱咖啡因咖啡
 *
 * @author Jiajing Li
 * @date 2019-10-09 20:42:45
 */
class Decaf extends Beverage {

    @Override
    public double cost() {
        return 7.0 + super.cost();
    }
}
