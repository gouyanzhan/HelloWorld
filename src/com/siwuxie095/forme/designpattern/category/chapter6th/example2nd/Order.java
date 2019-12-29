package com.siwuxie095.forme.designpattern.category.chapter6th.example2nd;

/**
 * 订单（命令 Command）
 *
 * @author Jiajing Li
 * @date 2019-10-28 14:56:08
 */
class Order {

    /**
     * 订单中含有对厨师的引用
     */
    private Chef chef;

    Order(Chef chef) {
        this.chef = chef;
    }

    /**
     * 让厨师根据订单准备餐点
     *
     * 相当于 execute()
     */
    void orderUp() {
        chef.wash();
        chef.cut();
        chef.cook();
    }
}
