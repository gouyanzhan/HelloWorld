package com.siwuxie095.forme.designpattern.category.chapter3rd.example4th;

/**
 * 深焙咖啡（具体组件）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:38:52
 */
class DarkRoast extends Beverage {

    DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 6.0;
    }
}
