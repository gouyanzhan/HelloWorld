package com.siwuxie095.forme.designpattern.category.chapter3rd.example4th;

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
