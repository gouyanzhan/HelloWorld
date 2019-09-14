package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带豆浆的脱咖啡因咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:41:58
 */
class DecafWithSoy extends Beverage {

    @Override
    public double cost() {
        return 7.0 + 1.5;
    }
}
