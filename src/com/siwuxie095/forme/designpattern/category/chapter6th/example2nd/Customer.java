package com.siwuxie095.forme.designpattern.category.chapter6th.example2nd;

/**
 * 顾客（客户 Client）
 *
 * @author Jiajing Li
 * @date 2019-10-28 14:53:38
 */
class Customer {

    /**
     * 创建订单
     */
    Order createOrder() {
        Chef chef = new Chef();
        return new Order(chef);
    }

}
