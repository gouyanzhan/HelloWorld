package com.siwuxie095.forme.designpattern.category.chapter14th.example8th;

/**
 * 抽象享元类
 *
 * @author Jiajing Li
 * @date 2019-11-11 18:19:34
 */
abstract class Flyweight {

    /**
     * 内部状态
     */
    private final String intrinsic;


    Flyweight(String intrinsic) {
        this.intrinsic = intrinsic;
    }

    /**
     * 操作，传入外部状态作为标识
     */
    abstract void operation(String extrinsic);

    String getIntrinsic() {
        return intrinsic;
    }
}
