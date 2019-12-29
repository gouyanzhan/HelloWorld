package com.siwuxie095.forme.designpattern.summary.pattern8th.adapter.example1st;

/**
 * 火鸡适配器（适配器）
 *
 * @author Jiajing Li
 * @date 2019-11-04 15:34:30
 */
class TurkeyAdapter implements Duck {

    /**
     * 持有对火鸡（被适配者）的引用
     */
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    /**
     * 因为火鸡飞的不够远，所以让它飞 5 次，以让它更像鸭子
     */
    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
