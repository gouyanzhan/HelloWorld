package com.siwuxie095.forme.designpattern.category.chapter14th.example4th;

/**
 * 指挥者
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:10:32
 */
class Director {

    private Builder builder;

    Director(Builder builder) {
        this.builder = builder;
    }

    Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
