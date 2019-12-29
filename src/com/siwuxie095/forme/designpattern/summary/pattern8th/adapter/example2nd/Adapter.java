package com.siwuxie095.forme.designpattern.summary.pattern8th.adapter.example2nd;

/**
 * 对象适配器
 *
 * @author Jiajing Li
 * @date 2019-11-04 16:53:25
 */
class Adapter implements Target {

    /**
     * 持有对被适配者的引用
     */
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
