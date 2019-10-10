package com.siwuxie095.forme.designpattern.summary.pattern3rd.decorator.example1st;

/**
 * 意大利咖啡（具体组件）
 *
 * @author Jiajing Li
 * @date 2019-10-09 20:43:19
 */
class Espresso extends Beverage {

    Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 8.0;
    }
}
