package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example1st;

/**
 * @author Jiajing Li
 * @date 2019-10-28 14:57:05
 */
public class Main {

    public static void main(String[] args) {
        // 顾客创建订单
        Customer customer = new Customer();
        Order order = customer.createOrder();
        // 女招待拿订单到订单柜台，让厨师准备餐点
        Waitress waitress = new Waitress();
        waitress.takeOrder(order);

    }

}
