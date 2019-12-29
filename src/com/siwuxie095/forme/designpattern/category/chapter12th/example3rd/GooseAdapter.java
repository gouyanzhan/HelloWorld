package com.siwuxie095.forme.designpattern.category.chapter12th.example3rd;

/**
 * 鹅适配器
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:44:13
 */
class GooseAdapter implements Quackable {

    /**
     * 将鹅适配成鸭子
     *
     * （1）鹅适配器实现了目标接口 Quackable。
     * （2）构造器中需要传入适配的鹅对象。
     * （3）当调用 quack() 方法时，会被委托到鹅的 honk() 方法。
     */

    private Goose goose;

    GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
