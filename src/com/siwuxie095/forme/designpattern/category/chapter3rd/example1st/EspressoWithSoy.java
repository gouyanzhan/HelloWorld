package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 带豆浆的意大利咖啡
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:45:02
 */
public class EspressoWithSoy extends Beverage {

    @Override
    public double cost() {
        return 8.0 + 1.5;
    }
}
