package com.siwuxie095.forme.designpattern.category.chapter14th.example4th;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:10:57
 */
class Client {

    void call() {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }

}
