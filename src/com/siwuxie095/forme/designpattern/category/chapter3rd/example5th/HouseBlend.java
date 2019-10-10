package com.siwuxie095.forme.designpattern.category.chapter3rd.example5th;

/**
 * 黑咖啡（具体组件）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:39:09
 */
class HouseBlend extends Beverage {

    HouseBlend() {
        description = "House Blend";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
