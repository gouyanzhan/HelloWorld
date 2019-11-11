package com.siwuxie095.forme.designpattern.category.chapter14th.example4th;

/**
 * 抽象生成器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:10:42
 */
abstract class Builder {

    protected Product product = new Product();

    abstract void buildPartA();

    abstract void buildPartB();

    abstract void buildPartC();

    Product getResult() {
        return product;
    }
}
