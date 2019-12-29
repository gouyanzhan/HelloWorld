package com.siwuxie095.forme.designpattern.summary.pattern18th.flyweight.example2nd;

/**
 * 非共享的具体享元类
 *
 * @author Jiajing Li
 * @date 2019-11-11 18:26:25
 */
class UnsharedConcreteFlyweight extends Flyweight {

    UnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    void operation(String extrinsic) {
        System.out.println("非共享的具体享元的内部状态：" + getIntrinsic() + "，外部状态：" + extrinsic);
    }
}
