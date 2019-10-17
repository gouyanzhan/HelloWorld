package com.siwuxie095.forme.designpattern.category.chapter3rd.example4th;

/**
 * 脱咖啡因咖啡（具体组件）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:39:44
 */
class Decaf extends Beverage {

    Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 7.0;
    }
}
