package com.siwuxie095.forme.designpattern.summary.pattern16th.builder.example2nd;

/**
 * 具体生成器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:10:51
 */
class ConcreteBuilder extends Builder {

    @Override
    void buildPartA() {
        product.setPartA("Part A");
    }

    @Override
    void buildPartB() {
        product.setPartB("Part B");
    }

    @Override
    void buildPartC() {
        product.setPartC("Part C");
    }
}
